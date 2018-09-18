package lokalize.models

data class WorksheetsResponse(val id: String,
                              val title: String,
                              val updated: Any,
                              val worksheets: Array<SpreadsheetWorksheet>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as WorksheetsResponse

        if (id != other.id) return false
        if (title != other.title) return false
        if (updated != other.updated) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + updated.hashCode()
        return result
    }
}