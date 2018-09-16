package lokalize.transformer

import lokalize.models.Options

class DartTransformer : AbstractTransformer() {
    override fun transformComment(comment: String): String = "// $comment"

    override fun transformKeyValue(key: String, value: String, closing: Boolean): String {
        var normalizedValue = value.replace("/%newline%/gi".toRegex(), "\\n")
        normalizedValue = normalizedValue.replace("/\"/gi".toRegex(), "\\\"")
        normalizedValue = normalizedValue.replace("/%([@df])/gi".toRegex(), "%$1")
        normalizedValue = normalizedValue.replace("/%s/gi".toRegex(), "%@")

        return "  \"$key\" : $normalizedValue \","
    }

    override fun insert(input: String?, newValues: String, options: Options): String {
        var fileInput = input ?: ""

        val generatedIndex = fileInput.indexOf(autogeneratedTag)
        if (generatedIndex >= 0) {
            fileInput = fileInput.substring(0, generatedIndex)
        }

        val header = options.header ?: ""
        val footer = options.footer ?: ""

        return fileInput + autogeneratedTag + "\n" +
                header +
                '{' + "\n" +
                newValues + "\n" + "};" + footer
    }

    override val autogeneratedTag: String
        get() = "// AUTO-GENERATED"

    companion object {
        const val NAME = "dart"
    }
}