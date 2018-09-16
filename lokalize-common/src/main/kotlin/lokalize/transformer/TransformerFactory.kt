package lokalize.transformer

object TransformerFactory {
    fun create(format: String): AbstractTransformer = when(format) {
        AndroidTransformer.NAME -> AndroidTransformer()
        IOSTransformer.NAME -> IOSTransformer()
        JsonTransformer.NAME -> JsonTransformer()
        DartTransformer.NAME -> DartTransformer()
        DartTemplateTransformer.NAME -> DartTemplateTransformer()
        DotNetTransformer.NAME -> DotNetTransformer()
        else -> throw IllegalArgumentException("Illegal format: $format")
    }
}