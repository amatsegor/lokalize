package lokalize.loader

import lokalize.Logger
import lokalize.external.GoogleSpreadsheet
import lokalize.models.SpreadsheetWorksheet
import lokalize.models.SpreadsheetRow
import lokalize.models.Worksheet
import kotlin.js.Promise

class WorksheetReader(private val gs: GoogleSpreadsheet, private val worksheets: List<SpreadsheetWorksheet>) {

    private val rows = arrayListOf<Worksheet>()

    private var index = 0

    fun read(callback: (cells: List<Worksheet>) -> Unit) {
        worksheets.forEach { worksheet ->
            readNext(worksheet).then {
                rows.add(Worksheet(it))
                index++

                if (index == worksheets.size) callback(rows)
            }.catch { err ->
                Logger.log(err)

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