package lokalize.models

import java.util.*

data class Config(
        val key: String?,
        val sheets: Array<String>?,
        val options: Options?,
        val targets: Array<Target>?
) {
    val isValid: Boolean
        get() {
            if (key.isNullOrEmpty()) return false
            if (sheets == null || sheets.isEmpty()) return false
            if (targets == null || targets.isEmpty()) return false
            if (options == null) return false
            with(options) {
                if (keyCol.isNullOrEmpty()) return false
                if (encoding.isNullOrEmpty()) return false
                if (format.isNullOrEmpty()) return false
                if (!VALID_FORMATS.contains(format)) return false
            }

            return true
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