package lokalize.loader

import lokalize.external.GoogleSpreadsheet
import lokalize.external.getGsRows
import lokalize.models.GSRow
import lokalize.models.SpreadsheetWorksheet

actual class WorksheetReader actual constructor(gs: GoogleSpreadsheet, worksheets: List<SpreadsheetWorksheet>) : AbstractWorksheetReader(gs, worksheets) {

    override suspend fun readNext(worksheet: SpreadsheetWorksheet): List<GSRow> = gs.getGsRows(worksheet.id)
}