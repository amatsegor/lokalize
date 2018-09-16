package lokalize.models.expect

// A SpreadsheetRow model appeared to be dependent from kotlin.js.Json class, so making in abstract
interface ISpreadsheetRow {
    val id: String

    operator fun get(key: String): String?
}