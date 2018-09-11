package lokalize.external

@JsModule("google-spreadsheet")
external class  GoogleSpreadsheet {
    constructor(key: String)

    fun getInfo(callback: (err: dynamic, data: dynamic /* WorksheetsResponse */) -> Unit)

    fun getCells(worksheetId: String, callback: (err: dynamic, cells: Array<dynamic>?) -> Unit)

    fun getRows(worksheetId: String, callback: (err: dynamic, rows: Array<dynamic>?) -> Unit)
}