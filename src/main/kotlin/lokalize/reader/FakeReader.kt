package lokalize.reader

import lokalize.external.GoogleSpreadsheet
import lokalize.models.LSEntity
import kotlin.js.Promise

class FakeReader : AbstractReader() {
    override fun select(sheets: List<GoogleSpreadsheet>, keyCol: String, valCol: String, callback: ReaderCallback?): Promise<List<LSEntity>?> {
        return Promise.resolve(listOf())
    }
}