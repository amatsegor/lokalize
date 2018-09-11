package lokalize.transformers

object TransformerFactory {
    fun create(format: String): AbstractTransformer = when(format) {
        "android" -> AndroidTransformer()
        "ios" -> IOSTransformer()
        "json" -> JsonTransformer()
        "dart" -> DartTransformer()
        "dartTemplate" -> DartTemplateTransformer()
        "dotnet" -> DotNetTransformer()
        else -> throw IllegalArgumentException("Illegal format: $format")
    }
}