package lokalize.writer

import lokalize.Logger
import lokalize.models.LSEntity
import lokalize.models.Options
import lokalize.transformer.AbstractTransformer

actual class FileWriter actual constructor() : AbstractWriter() {
    actual override fun write(path: String, entities: List<LSEntity>, transformer: AbstractTransformer, options: Options) {
        Logger.info("FileWriter works")
    }
}