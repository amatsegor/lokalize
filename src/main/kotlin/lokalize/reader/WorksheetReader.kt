package lokalize.reader

import lokalize.external.GoogleSpreadsheet
import lokalize.external.SpreadsheetCell
import lokalize.external.SpreadsheetWorksheet

class WorksheetReader(private val gs: GoogleSpreadsheet, private val worksheets: List<SpreadsheetWorksheet>, private val sheetsFilter: List<String>) {

    private val cells = arrayListOf<List<SpreadsheetCell>>()

    private var index = 0

    fun read(callback: (cells: List<List<SpreadsheetCell>>) -> Unit) {
        worksheets.forEach{
            if (GSReader.shouldUseWorksheet(sheetsFilter, it.title, index + 1)) {
                gs.getCells(it.id) { err, cells ->
                    index++

                    if (err != null) {
                        console.log(err)
                    }

                    if (cells != null) {
                        this.cells.add(cells.toList())
                    }

                    if (index == worksheets.size) callback(this.cells)
                }
            } else {
                index++

                if (index == worksheets.size) callback(this.cells)
            }
        }
    }
}