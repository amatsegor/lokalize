package lokalize.tasks

import lokalize.models.LSEntity
import lokalize.models.Options
import lokalize.transformers.AbstractTransformer
import lokalize.writer.AbstractWriter
import lokalize.writer.FileWriter

class SaveTask(private val entities: Map<String, List<LSEntity>>, private val transformer: AbstractTransformer, private val options: Options) {

    fun save(writer: AbstractWriter = FileWriter()) {
        entities.entries.forEach {
            console.log("Writing ${it.key} with ${it.value.size} entries")

            writer.write(it.key, it.value, transformer, options)
        }
    }
}