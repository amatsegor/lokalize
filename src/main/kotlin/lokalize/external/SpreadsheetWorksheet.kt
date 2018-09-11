package lokalize.external

data class SpreadsheetWorksheet(val url: String,
                                val id: String,
                                val title: String,
                                val rowCount: Int,
                                val colCount: Int)