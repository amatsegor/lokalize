package lokalize

expect object Logger {
    fun log(message: String)

    fun log(throwable: Throwable)

    fun error(message: String)

    fun warn(message: String)

    fun info(message: String)
}