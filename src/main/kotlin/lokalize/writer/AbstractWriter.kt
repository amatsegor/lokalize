package lokalize.writer

import lokalize.models.LSEntity
import lokalize.models.Options
import lokalize.transformers.AbstractTransformer

abstract class AbstractWriter {
    abstract fun write(path: String, lines: List<LSEntity>, transformer: AbstractTransformer, options: Options)
}