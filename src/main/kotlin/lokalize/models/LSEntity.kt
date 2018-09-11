package lokalize.models

abstract class LSEntity(var key: String) {
    abstract val isEmpty: Boolean

    abstract val isComment: Boolean
}