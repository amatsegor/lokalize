package lokalize

import mu.KotlinLogging

val logger = KotlinLogging.logger("Lokalize")

actual object Logger {

    actual fun log(message: String) {
        logger.debug(message)
    }

    actual fun log(throwable: Throwable) {
        logger.error(throwable.localizedMessage)
    }

    actual fun error(message: String) {
        logger.error(message)
    }

    actual fun warn(message: String) {
        logger.warn(message)
    }

    actual fun info(message: String) {
        logger.info(message)
    }
}