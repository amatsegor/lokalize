package lokalize.models

class LSLine(key: String, val value: String) : LSEntity(key) {

    override val isEmpty: Boolean
        get() = value.isEmpty()
    override val isComment: Boolean
        get() = checkIsComment(key)

    init {
        if (isComment) {
            this.key = normalizeComment(key)
        }
    }

    companion object {
        private val COMMENT_STARTERS = arrayOf("//", "#")

        private fun checkIsComment(value: String) = COMMENT_STARTERS.any { value.indexOf(it) == 0 }

        private fun normalizeComment(value: String): String {
            var normalized = value

            COMMENT_STARTERS.forEach {
                val index = normalized.indexOf(it)
                if (index == 0) {
                    normalized = normalized.substring(it.length, normalized.length - it.length)
                }
            }

            return normalized.trim()
        }
    }
}