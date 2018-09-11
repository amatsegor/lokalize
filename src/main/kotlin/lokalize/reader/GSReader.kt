package lokalize.reader

import Q
import lokalize.external.GoogleSpreadsheet
import lokalize.external.SpreadsheetCell
import lokalize.external.SpreadsheetWorksheet
import lokalize.external.WorksheetsResponse
import lokalize.models.LSEntity
import kotlin.js.Promise

class GSReader(spreadsheetKey: String, val sheetsFilter: List<String>) : AbstractReader() {

    private var isFetching = false

    private var sheet = GoogleSpreadsheet(spreadsheetKey)

    private var fetchedWorksheets: List<SpreadsheetCell>? = null
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

    override fun select(sheets: List<GoogleSpreadsheet>, keyCol: String, valCol: String, callback: (List<LSEntity>) -> Unit): Promise<List<LSEntity>> {
        val deferred = Q.defer()

        Q.`when`(fetchAllCells(), callback = { cells: List<SpreadsheetCell> ->
            console.log("selected ${cells.size} cells")

            val entities = extractFromRawData(cells, keyCol, valCol)
            deferred.resolve(entities)
        }).fail(callback = { err ->
            console.error(err)
        })

        return deferred.promise
    }

    private fun extractFromRawData(cells: List<SpreadsheetCell>, keyCol: String, valCol: String): List<LSEntity> {
        extractFromWorksheet(cells, keyCol, valCol)
//        val results = arrayListOf<LSEntity>()
//        sheets.map { extractFromWorksheet(it, keyCol, valCol) }.forEach { results.addAll(it) }
        return listOf()
    }

    private fun extractFromWorksheet(cells: List<SpreadsheetCell>, keyCol: String, valCol: String): List<LSEntity> {
        val results = listOf<LSEntity>()

        flattenWorksheet(cells)

        return results
    }

    private fun flattenWorksheet(cells: List<SpreadsheetCell>) {
        console.log("Cell[0] = ${cells[0]}")
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
    }
}