package lokalize.loader

import lokalize.Logger
import lokalize.external.GoogleSpreadsheet
import lokalize.external.WorksheetsResponse
import lokalize.models.Worksheet
import kotlin.coroutines.experimental.suspendCoroutine

class GoogleSheetLoader(private val spreadsheetKey: String, private vararg val sheetsFilter: String) : AbstractLoader() {

    private var fetchedWorksheets: List<Worksheet>? = null

    override suspend fun load(): List<Worksheet> {
        val sheet = GoogleSpreadsheet(spreadsheetKey)

        val worksheets = fetchedWorksheets

        if (worksheets == null) {
            Logger.log("Fetching worksheets...")

            return suspendCoroutine { cont ->
                sheet.getInfo { err, data ->
                    when {
                        err != null -> {
                            Logger.error("Error while fetching the Spreadsheet ($err)")
                            Logger.warn("WARNING! Check that your spreadsheet is \"Published\" in \"File > Publish to the web...\"")
                            cont.resumeWithException(Exception("Error while fetching the Spreadsheet ($err)"))
                        }

                        data != null -> {
                            val worksheetsData = JSON.parse<WorksheetsResponse>(JSON.stringify(data))

                            val worksheetsList = worksheetsData.worksheets.filter { sheetsFilter.contains(it.title) || sheetsFilter.contains("*") }

                            val worksheetReader = WorksheetReader(sheet, worksheetsList.toList())
                            worksheetReader.read {
                                this.fetchedWorksheets = it
                                cont.resume(it)
                            }
                        }

                        else -> cont.resumeWithException(IllegalStateException("Got neither data or error"))
                    }
                }
            }
        } else {
            Logger.log("Using cached worksheets")
            return worksheets
        }
    }
}