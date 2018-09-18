package lokalize.external

import lokalize.Logger
import lokalize.gsheets.SheetsServiceUtil
import lokalize.models.GSRow
import lokalize.models.SpreadsheetWorksheet
import lokalize.models.WorksheetsResponse

actual class GoogleSpreadsheet actual constructor(key: String) {

    private val spreadsheetKey = key

    actual fun getInfo(callback: (err: Error?, data: WorksheetsResponse?) -> Unit) {
        Logger.debug("Getting spreadsheet info")

        val spreadsheet = SheetsServiceUtil.getSheetsService()
                .spreadsheets()
                .get(spreadsheetKey)
                .execute()

        Logger.debug("Spreadsheet \"${spreadsheet.properties.title}\" loaded")

        val sheets = spreadsheet.sheets.map {
            val properties = it.properties
            SpreadsheetWorksheet("", properties.sheetId.toString(), properties.title, properties.gridProperties.rowCount, properties.gridProperties.columnCount)
        }.toTypedArray()

        val wsResponse = WorksheetsResponse(spreadsheetKey, spreadsheet.properties.title, "", sheets)

        callback.invoke(null, wsResponse)
    }

    fun getRows(worksheetTitle: String): List<GSRow> {
        Logger.info("Loading sheet \"$worksheetTitle\"")

        val valueRange = SheetsServiceUtil.getSheetsService()
                .spreadsheets()
                .values()
                .get(spreadsheetKey, worksheetTitle)
                .execute()

        val values = valueRange.getValues()
        val keyRow = values[0] as ArrayList<String>

        val rows = arrayListOf<ArrayList<Pair<String, String>>>()

        values.drop(1).forEachIndexed { _, list ->
            val row = arrayListOf<Pair<String, String>>()
            list.forEachIndexed { index, value ->
                val pair = keyRow[index].toLowerCase() to (value as? String ?: "").toLowerCase()
                row.add(pair)
            }
            rows.add(row)
        }

        return rows.map { GSRow(it) }
    }
}