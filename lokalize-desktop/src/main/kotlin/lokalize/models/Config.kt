package lokalize.models

import java.util.*

data class Config(
        val key: String?,
        val sheets: Array<String>?,
        val options: Options?,
        val targets: Array<Target>?
) {
    fun validate(): String? {
        if (key.isNullOrEmpty()) return "Invalid key"
        if (sheets == null || sheets.isEmpty()) return "Please, specify sheets to use"
        if (targets == null || targets.isEmpty()) return "Please, specify loading targets"
        if (options == null) return "Please, specify options in your config file"
        with(options) {
            if (keyCol.isNullOrEmpty()) return "Parameter keycol is empty"
            if (format.isNullOrEmpty()) return "Parameter format is empty"
            if (!VALID_FORMATS.contains(format)) return "Format $format is not valid,\nValid formats: ${VALID_FORMATS.joinToString()}"
        }

        return null
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Config

        if (key != other.key) return false
        if (!Arrays.equals(sheets, other.sheets)) return false
        if (options != other.options) return false
        if (!Arrays.equals(targets, other.targets)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = key?.hashCode() ?: 1
        result = 31 * result + Arrays.hashCode(sheets)
        result = 31 * result + (options?.hashCode() ?: 0)
        result = 31 * result + Arrays.hashCode(targets)
        return result
    }

    companion object {
        private val VALID_FORMATS = arrayOf("android", "ios", "dart", "dartTemplate", "json", "dotnet")
    }
}