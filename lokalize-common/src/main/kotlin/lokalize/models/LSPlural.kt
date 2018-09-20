package lokalize.models

class LSPlural(key: String, val values: MutableMap<String, String> = hashMapOf()) : LSEntity(key) {

    override val isEmpty: Boolean
        get() = values.isEmpty()

    override val isComment: Boolean
        get() = false

    operator fun plus(line: LSLine): LSPlural {
        values[line.key] = line.value
        return this
    }

    enum class Quantifier {
        ZERO,
        ONE,
        TWO,
        FEW,
        MANY,
        OTHER;

        companion object {
            fun isQuantifierValid(quantifier: String) = try {
                Quantifier.valueOf(quantifier.toUpperCase())
                true
            } catch (e: IllegalArgumentException) {
                false
            }
        }

    }
}