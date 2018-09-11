package lokalize.reader

import lokalize.external.GoogleSpreadsheet
import lokalize.models.LSEntity
import kotlin.js.Promise

abstract class AbstractReader {
    abstract fun select(sheets: List<GoogleSpreadsheet>, keyCol: String, valCol: String, callback: (List<LSEntity>) -> Unit) : Promise<List<LSEntity>>
}