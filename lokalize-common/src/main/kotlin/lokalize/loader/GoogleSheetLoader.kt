package lokalize.loader

import lokalize.Logger
import lokalize.external.GoogleSpreadsheet
import lokalize.models.Worksheet
import kotlin.coroutines.experimental.suspendCoroutine

class GoogleSheetLoader constructor(private val spreadsheetKey: String, private val sheetsFilter: Array<String>) : AbstractLoader() {

    private var fetchedWorksheets: List<Worksheet>? = null

    override suspend fun load(): List<Worksheet> {
        val sheet = GoogleSpreadsheet(spreadsheetKey)

        val worksheets = fetchedWorksheets

        if (worksheets == null) {
            Logger.debug("Fetching worksheets...")

            return suspendCoroutine { cont ->
                sheet.getInfo { err, data ->
                    when {
                        err != null -> {
                            Logger.error("Error while fetching the Spreadsheet ($err)")
                            Logger.warn("WARNING! Check that your spreadsheet is \"Published\" in \"File > Publish to the web...\"")
                            cont.resumeWithException(Exception("Error while fetching the Spreadsheet ($err)"))
                        }

                        data != null -> {
                            Logger.debug("Got ${data.worksheets.size} worksheets")

                            val worksheetsList = data.worksheets.filter { sheetsFilter.contains(it.title) || sheetsFilter.contains("*") }

                            val worksheetReader = WorksheetReader(sheet, worksheetsList.toList())
                            worksheetReader.read {
                                Logger.debug("Fetched ${it.size} sheets")

                                this.fetchedWorksheets = it
                                cont.resume(it)
                            }
                        }

                        else -> cont.resumeWithException(IllegalStateException("Got neither data or error"))
                    }
                }
            }
        } else {
            Logger.info("Using cached worksheets")
            return worksheets
        }
    }
}