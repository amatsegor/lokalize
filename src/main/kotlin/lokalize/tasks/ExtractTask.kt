package lokalize.tasks

import lokalize.extractor.DefaultExtractor
import lokalize.extractor.Extractor
import lokalize.models.LSEntity
import lokalize.models.Options
import lokalize.models.Worksheet
import lokalize.transformers.TransformerFactory

class ExtractTask(private val worksheets: List<Worksheet>, private val opts: Options, private val extractor: Extractor = DefaultExtractor()) {

    fun extract(valueCol: String? = null, filePath: String): ExtractTask {
        val valCol = valueCol ?: opts.valueCol

        console.log("Extracting $valCol...")

        loadedEntities[filePath] = extractor.extract(worksheets, opts.keyCol, valCol)

        return this
    }

    fun transform(): SaveTask {
        console.log("Transforming ${loadedEntities.size} languages")

        val transformer = TransformerFactory.create(opts.format)
        return SaveTask(loadedEntities, transformer, opts)
    }

    companion object {
        private val loadedEntities = hashMapOf<String, List<LSEntity>>()
    }
}