package lokalize.loader

import lokalize.Logger
import lokalize.models.Worksheet

actual class GoogleSheetLoader actual constructor(private val spreadsheetKey: String, sheetsFilter: Array<String>) : AbstractLoader() {

    override suspend fun load(): List<Worksheet> {
        Logger.info("GoogleSheetLoader works")
        return emptyList()
    }
}