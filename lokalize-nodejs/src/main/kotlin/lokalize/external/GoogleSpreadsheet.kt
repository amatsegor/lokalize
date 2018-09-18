package lokalize.external

import lokalize.models.GSRow
import lokalize.models.WorksheetsResponse
import kotlin.coroutines.experimental.suspendCoroutine

@JsModule("google-spreadsheet")
actual external class GoogleSpreadsheet actual constructor(key: String) {

    actual fun getInfo(callback: (err: Error?, data: WorksheetsResponse?) -> Unit)

    fun getRows(worksheetId: String, callback: (err: Error?, rows: Array<dynamic>?) -> Unit)
}

suspend fun GoogleSpreadsheet.getGsRows(worksheetId: String): List<GSRow> {
    return suspendCoroutine { cont ->
        getRows(worksheetId) { err, rows ->
            if (err != null) {
                cont.resumeWithException(err)
                return@getRows
            }

            if (rows != null) {
                val gsRows = rows.map { row ->
                    val fieldsMap = Object.keys(row).map { it to (row[it] as? String ?: "") }
                    GSRow(fieldsMap)
                }
                cont.resume(gsRows)
            }
        }
    }
}