package lokalize.models

class LSPlural(key: String, private val values: Map<String, String> = hashMapOf()): LSEntity(key) {

    override val isEmpty: Boolean
        get() = values.isEmpty()

    override val isComment: Boolean
        get() = false
}