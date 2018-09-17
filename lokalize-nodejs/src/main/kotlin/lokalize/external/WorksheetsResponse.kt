package lokalize.external

import lokalize.models.SpreadsheetWorksheet

data class WorksheetsResponse(val id: String,
                         val title: String,
                         val updated: Any,
                         val author: dynamic,
                         val worksheets: Array<SpreadsheetWorksheet>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class.js != other::class.js) return false

        other as WorksheetsResponse

        if (id != other.id) return false
        if (title != other.title) return false
        if (updated != other.updated) return false
        if (author != other.author) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + updated.hashCode()
        result = 31 * result + (author?.hashCode() ?: 0)
        return result
    }
}