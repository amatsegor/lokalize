package lokalize.loader

import lokalize.external.GoogleSpreadsheet
import lokalize.external.SpreadsheetRow
import lokalize.external.SpreadsheetWorksheet
import lokalize.models.Worksheet
import kotlin.js.Promise

class WorksheetReader(private val gs: GoogleSpreadsheet, private val worksheets: List<SpreadsheetWorksheet>) {

    private val rows = arrayListOf<Worksheet>()

    private var index = 0

    fun read(callback: (cells: List<Worksheet>) -> Unit) {
        worksheets.forEach {
            readNext(it).then {
                rows.add(Worksheet(it))
                index++

                if (index == worksheets.size) callback(rows)
            }.catch { err ->
                console.log(err)

                index++

                if (index == worksheets.size) callback(rows)
            }
        }
    }

    private fun readNext(worksheet: SpreadsheetWorksheet): Promise<List<SpreadsheetRow>> = Promise { resolve, reject ->
        gs.getRows(worksheet.id) { err, jsonRows ->

            if (err != null) {
                reject(err)
            }

            if (jsonRows.isEmpty()) {
                resolve(listOf())
            } else {
                resolve(jsonRows.map { SpreadsheetRow(it) })
            }
        }
    }
}