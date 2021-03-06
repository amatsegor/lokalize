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

    fun extract(valueCol: String, filePath: String): ExtractTask {
        Logger.info("Extracting $valueCol...")

        loadedEntities[filePath] = extractor.extract(worksheets, opts.keyCol ?: "", valueCol)

        return this
    }

    fun transform(transformer: AbstractTransformer? = null): SaveTask {
        Logger.info("Transforming ${loadedEntities.size} languages")

        val transformer = transformer ?: TransformerFactory.create(opts.format ?: "")
        return SaveTask(loadedEntities, transformer, opts)
    }

    companion object {
        private val loadedEntities = hashMapOf<String, List<LSEntity>>()
    }
}