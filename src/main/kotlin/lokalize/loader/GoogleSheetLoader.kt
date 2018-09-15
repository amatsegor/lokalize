package lokalize.loader

import lokalize.external.GoogleSpreadsheet
import lokalize.external.SpreadsheetRow
import lokalize.external.WorksheetsResponse
import lokalize.models.Worksheet
import kotlin.coroutines.experimental.suspendCoroutine

class GoogleSheetLoader(private val spreadsheetKey: String, private val sheetsFilter: Array<String>) : AbstractLoader() {

    private var fetchedWorksheets: List<Worksheet>? = null

    override suspend fun load(): List<Worksheet> {
        val sheet = GoogleSpreadsheet(spreadsheetKey)

        val worksheets = fetchedWorksheets

        if (worksheets == null) {
            console.log("Fetching worksheets...")

            return suspendCoroutine { cont ->
                sheet.getInfo { err, data ->
                    when {
                        err != null -> {
                            console.error("Error while fetching the Spreadsheet ($err)")
                            console.warn("WARNING! Check that your spreadsheet is \"Published\" in \"File > Publish to the web...\"")
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
            console.log("Using cached worksheets")
            return worksheets
        }
    }
}