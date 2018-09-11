package lokalize.models

class LSArray(key: String, val lines: List<LSLine>) : LSEntity(key) {
    override val isEmpty: Boolean
        get() = lines.isEmpty()

    override val isComment: Boolean
        get() = false
}