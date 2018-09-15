package lokalize.models

class LSArray(key: String, val lines: MutableList<LSLine> = arrayListOf()) : LSEntity(key) {
    override val isEmpty: Boolean
        get() = lines.isEmpty()

    override val isComment: Boolean
        get() = false

    operator fun plus(line: LSLine) : LSArray {
        lines.add(line)
        return this
    }
}