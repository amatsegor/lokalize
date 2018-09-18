package lokalize

expect object Logger {
    fun debug(message: String)

    fun error(throwable: Throwable)

    fun error(message: String)

    fun warn(message: String)

    fun info(message: String)
}