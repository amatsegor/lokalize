package lokalize.external

@JsModule("google-spreadsheet")
external class SpreadsheetCell {
    constructor(spreadsheet: GoogleSpreadsheet, worksheetId: String, data: dynamic)

    val batchId: String
    val col: Int
    val row: Int
    val _value: String
}