package lokalize.models

import lokalize.models.expect.ISpreadsheetRow
import kotlin.js.Json

class SpreadsheetRow(private val jsonRow: Json) : ISpreadsheetRow {
    override val id: String
        get() = jsonRow["id"]?.toString() ?: ""

    override fun get(key: String): String? = jsonRow[key.toLowerCase()]?.toString()
}