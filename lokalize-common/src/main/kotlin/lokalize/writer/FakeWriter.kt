package lokalize.writer

import lokalize.models.LSEntity
import lokalize.models.Options
import lokalize.transformer.AbstractTransformer

class FakeWriter : AbstractWriter() {
    override fun write(path: String, entities: List<LSEntity>, transformer: AbstractTransformer, options: Options) {
        println("Fake writer: $entities")
    }
}