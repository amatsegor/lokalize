package lokalize.writer

import lokalize.models.LSEntity
import lokalize.models.Options
import lokalize.transformer.AbstractTransformer

expect class FileWriter(): AbstractWriter {
    override fun write(path: String, entities: List<LSEntity>, transformer: AbstractTransformer, options: Options)
}