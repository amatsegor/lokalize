package lokalize.external

import kotlin.js.Json

class SpreadsheetRow(private val jsonRow: Json) {
    val id: String
        get() = jsonRow["id"]?.toString() ?: ""

    fun getValueByKey(langId: String): String? = jsonRow[langId.toLowerCase()]?.toString()
}