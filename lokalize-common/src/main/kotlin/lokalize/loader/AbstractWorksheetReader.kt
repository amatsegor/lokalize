package lokalize.loader

import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import lokalize.external.GoogleSpreadsheet
import lokalize.models.GSRow
import lokalize.models.SpreadsheetWorksheet
import lokalize.models.Worksheet

abstract class AbstractWorksheetReader(protected val gs: GoogleSpreadsheet, private val worksheets: List<SpreadsheetWorksheet>) {
    private val rows = arrayListOf<Worksheet>()

    private var index = 0

    fun read(callback: (cells: List<Worksheet>) -> Unit) {
        worksheets.forEach { worksheet ->
            GlobalScope.launch {
                val sheet = Worksheet(readNext(worksheet))
                rows.add(sheet)

                index++
                if (index == worksheets.size) callback(rows)
            }
        }
    }

    abstract suspend fun readNext(worksheet: SpreadsheetWorksheet): List<GSRow>
}