package lokalize.models

data class SpreadsheetWorksheet(val url: String,
                                val id: String,
                                val title: String,
                                val rowCount: Int,
                                val colCount: Int)