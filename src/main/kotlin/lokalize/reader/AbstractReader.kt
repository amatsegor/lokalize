package lokalize.reader

import lokalize.external.GoogleSpreadsheet
import lokalize.models.LSEntity
import kotlin.js.Promise

typealias ReaderCallback = (List<LSEntity>) -> Unit

abstract class AbstractReader {
    abstract fun select(sheets: List<GoogleSpreadsheet>, keyCol: String, valCol: String, callback: ReaderCallback? = null): Promise<List<LSEntity>?>
}