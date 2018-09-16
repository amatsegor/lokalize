package lokalize.writer

import lokalize.models.LSEntity
import lokalize.models.Options
import lokalize.transformer.AbstractTransformer

abstract class AbstractWriter {
    abstract fun write(path: String, entities: List<LSEntity>, transformer: AbstractTransformer, options: Options)
}