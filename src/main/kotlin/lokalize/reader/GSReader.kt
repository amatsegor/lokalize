package lokalize.reader

import Q
import lokalize.external.GoogleSpreadsheet
import lokalize.external.SpreadsheetCell
import lokalize.external.WorksheetsResponse
import lokalize.models.LSArray
import lokalize.models.LSEntity
import lokalize.models.LSLine
import kotlin.js.Promise

class GSReader(spreadsheetKey: String, val sheetsFilter: List<String>) : AbstractReader() {

    private var isFetching = false

    private var sheet = GoogleSpreadsheet(spreadsheetKey)

    private var fetchedWorksheets: List<List<SpreadsheetCell>>? = null
    private var fetchDeferred = Q.defer()

    private fun fetchAllCells(): List<Any> {
        val worksheets = fetchedWorksheets

        if (worksheets == null) {
            if (!isFetching) {
                isFetching = true

                console.log("Fetching...")

                sheet.getInfo { err, data ->
                    when {
                        err != null -> {
                            console.error("Error while fetching the Spreadsheet ($err)")
                            console.warn("WARNING! Check that your spreadsheet is \"Published\" in \"File > Publish to the web...\"")
                            fetchDeferred.reject(err)
                        }
                        data != null -> {
                            isFetching = false

                            val worksheetsData = JSON.parse<WorksheetsResponse>(JSON.stringify(data))

                            val worksheetReader = WorksheetReader(sheet, worksheetsData.worksheets.toList(), sheetsFilter)
                            worksheetReader.read {
                                fetchedWorksheets = it
                                fetchDeferred.resolve(it)
                            }
                        }
                        else -> fetchDeferred.reject("Got neither data or error")
                    }

                    return@getInfo
                }
            }

            return fetchDeferred.promise
        } else {
            return worksheets
        }
    }

    override fun select(sheets: List<GoogleSpreadsheet>, keyCol: String, valCol: String, callback: ReaderCallback?): Promise<List<LSEntity>?> {
        val deferred = Q.defer()

        Q.`when`(fetchAllCells(), callback = { cells: List<List<SpreadsheetCell>> ->
            console.log("selected ${cells.size} cells")

            val entities = extractFromRawData(cells, keyCol, valCol)
            deferred.resolve(entities)
        }).fail(callback = { err ->
            console.error(err)
        })

        return deferred.promise
    }

    private fun extractFromRawData(cellLists: List<List<SpreadsheetCell>>, keyCol: String, valCol: String): List<LSEntity> {
        val extractedCells = arrayListOf<LSEntity>()

        cellLists.map {
            extractedCells.addAll(extractFromWorksheet(it, keyCol, valCol))
        }

        return extractedCells
    }

    private fun extractFromWorksheet(cells: List<SpreadsheetCell>, keyCol: String, valCol: String): List<LSEntity> {
        val results = arrayListOf<LSEntity>()

        val rows = flattenWorksheet(cells)

        var isInArray = false
        var arrayName = ""
        var array = arrayListOf<LSLine>()

        val headers = rows[0]
        if (headers != null) {
            var keyIndex = -1
            var valIndex = -1

            for (i in 0..headers.size) {
                val value = headers[i]
                if (value == keyCol) {
                    keyIndex = i
                }
                if (value == valCol) {
                    valIndex = i
                }
            }

            rows.filterNotNull().forEach { row ->
                val keyValue = row[keyIndex] ?: ""
                val valValue = row[valIndex] ?: ""

                when {
                    keyValue.matches(arrayStartRegex) -> {
                        arrayName = keyValue.substring(1, keyValue.indexOf("]"))
                        isInArray = true
                    }

                    keyValue.matches(arrayEndRegex) -> {
                        results.add(LSArray(arrayName, array))
                        isInArray = false
                        arrayName = ""
                    }

                    isInArray -> {
                        array.add(LSLine(keyValue, valValue))
                    }

                    else -> {
                        results.add(LSLine(keyValue, valValue))
                    }
                }
            }
        }

        return results
    }

    private fun flattenWorksheet(cells: List<SpreadsheetCell>) : List<List<String?>?> {
        val rows = arrayListOf<MutableList<String>?>()
        var lastRowIndex = 1

        console.log("Cells size: ${cells.size}")

        cells.forEach { cell ->
            val rowIndex = cell.row

            val diffWithLastRow = rowIndex - lastRowIndex
            if (diffWithLastRow > 1) {
                for (j in 0..diffWithLastRow) {
                    val newRow = arrayListOf<String>()
                    newRow[cell.col - 1] = ""

                    rows[lastRowIndex + j] = newRow
                }
            }
            lastRowIndex = rowIndex

            var row = rows[cell.row - 1]
            if (row == null) {
                row = arrayListOf()

                rows[cell.row - 1] = row
            }
            row[cell.col - 1] = cell._value
        }

        return rows
    }

    companion object {
        fun shouldUseWorksheet(worksheetTitles: List<String>, title: String, index: Int): Boolean {
            if (shouldIncludeAllWorksheets(worksheetTitles)) {
                return true
            } else {
                worksheetTitles.forEach {
                    val intValue = it.toIntOrNull()
                    if (intValue != null && intValue == index) return true
                    if (it == title) return true
                }

                return false
            }
        }

        private fun shouldIncludeAllWorksheets(sheetsFilter: List<String>?): Boolean {
            return sheetsFilter == null || sheetsFilter.contains("*")
        }

        private val arrayStartRegex = Regex("\\[[\\w\\-_]+]")
        private val arrayEndRegex = Regex("\\[/\\S+]")
    }
}