package lokalize.loader

import lokalize.external.GoogleSpreadsheet
import lokalize.models.SpreadsheetWorksheet

expect class WorksheetReader(gs: GoogleSpreadsheet, worksheets: List<SpreadsheetWorksheet>): AbstractWorksheetReader