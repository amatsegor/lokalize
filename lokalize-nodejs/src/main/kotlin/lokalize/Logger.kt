package lokalize

actual object Logger {
    actual fun error(message: String) {
        console.warn(message)
    }

    actual fun error(throwable: Throwable) {
        console.warn(throwable)
    }

    actual fun warn(message: String) {
        console.warn(message)
    }

    actual fun info(message: String) {
        console.info(message)
    }

    actual fun debug(message: String) {
        console.info("D/$message")
    }
}