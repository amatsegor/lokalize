package lokalize.tasks

import lokalize.Logger
import lokalize.models.LSEntity
import lokalize.models.Options
import lokalize.transformer.AbstractTransformer
import lokalize.writer.AbstractWriter
import lokalize.writer.FileWriter

class SaveTask(private val entities: Map<String, List<LSEntity>>, private val transformer: AbstractTransformer, private val options: Options) {

    fun save(writer: AbstractWriter = FileWriter()) {
        entities.entries.forEach {
            Logger.info("Saving ${it.value.size} entries to ${it.key}")

            writer.write(it.key, it.value, transformer, options)
        }
    }
}