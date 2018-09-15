package lokalize.extractor

import lokalize.models.LSEntity
import lokalize.models.Worksheet

interface Extractor {
    fun extract(rowLists: List<Worksheet>, keyCol: String, valCol: String): List<LSEntity>
}