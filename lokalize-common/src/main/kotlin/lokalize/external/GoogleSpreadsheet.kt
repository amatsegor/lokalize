package lokalize.external

import lokalize.models.WorksheetsResponse

expect class GoogleSpreadsheet(key: String) {
    fun getInfo(callback: (err: Error?, data: WorksheetsResponse?) -> Unit)
}