package lokalize

import lokalize.loader.GoogleSheetLoader
import lokalize.tasks.LoadTask

object Lokalize {
    fun fromGoogleSpreadsheet(spreadsheetKey: String, vararg sheets: String): LoadTask {
        return LoadTask(GoogleSheetLoader(spreadsheetKey, sheets as Array<String>))
    }
}

