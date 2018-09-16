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
            Logger.log("Writing ${it.key} with ${it.value.size} entries")

            writer.write(it.key, it.value, transformer, options)
        }
    }
}