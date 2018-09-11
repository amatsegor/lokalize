package lokalize.writer

import lokalize.models.LSEntity
import lokalize.models.Options
import lokalize.transformers.AbstractTransformer

class FakeWriter : AbstractWriter() {
    override fun write(path: String, lines: List<LSEntity>, transformer: AbstractTransformer, options: Options) {
        println("Fake writer: $lines")
    }
}