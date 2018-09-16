package lokalize.tasks

import lokalize.Logger
import lokalize.extractor.DefaultExtractor
import lokalize.extractor.Extractor
import lokalize.models.LSEntity
import lokalize.models.Options
import lokalize.models.Worksheet
import lokalize.transformer.AbstractTransformer
import lokalize.transformer.TransformerFactory

class ExtractTask(private val worksheets: List<Worksheet>, private val opts: Options, private val extractor: Extractor = DefaultExtractor()) {

    fun extract(valueCol: String? = null, filePath: String): ExtractTask {
        val valCol = valueCol ?: opts.valueCol

        Logger.log("Extracting $valCol...")

        loadedEntities[filePath] = extractor.extract(worksheets, opts.keyCol, valCol)

        return this
    }

    fun transform(transformer: AbstractTransformer? = null): SaveTask {
        Logger.log("Transforming ${loadedEntities.size} languages")

        val transformer = transformer ?: TransformerFactory.create(opts.format)
        return SaveTask(loadedEntities, transformer, opts)
    }

    companion object {
        private val loadedEntities = hashMapOf<String, List<LSEntity>>()
    }
}