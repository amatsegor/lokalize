package lokalize

actual object Logger {
    actual fun log(message: String) {
        console.log(message)
    }

    actual fun log(throwable: Throwable) {
        console.log(throwable)
    }

    actual fun error(message: String) {
        console.warn(message)
    }

    actual fun warn(message: String) {
        console.warn(message)
    }

    actual fun info(message: String) {
        console.info(message)
    }
}