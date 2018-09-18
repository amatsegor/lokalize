package lokalize

import mu.KotlinLogging

actual object Logger {

    private val logger = KotlinLogging.logger("Lokalize")

    actual fun error(throwable: Throwable) {
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

    actual fun debug(message: String) {
        logger.debug(message)
    }
}