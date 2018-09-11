package lokalize.external

data class WorksheetsResponse(val id: String,
                         val title: String,
                         val updated: Any,
                         val author: dynamic,
                         val worksheets: Array<SpreadsheetWorksheet>)