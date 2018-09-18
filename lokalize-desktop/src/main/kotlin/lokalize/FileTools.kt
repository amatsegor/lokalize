package lokalize

import java.io.File
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths

actual object FileTools {

    actual val getCurrentDirectory: String
        get() = System.getProperty("user.dir")

    actual fun isFileExistsSync(filePath: String): Boolean = Files.exists(Paths.get(filePath))

    actual fun readFileSync(filePath: String, encoding: String): String {
        val file = File(filePath)
        return file.readText(Charset.forName(encoding))
    }

    actual fun writeFileSync(filePath: String, content: String, encoding: String) {
        Files.write(Paths.get(filePath), content.toByteArray(Charset.forName(encoding)))
    }

    actual fun createPathSync(path: String) {
        val pathObject = Paths.get(path)

        try {
            Files.createDirectories(pathObject)
        } catch (ex: Exception) {
            Logger.error(ex.message ?: "Can't create path $path")
        }
    }

    actual fun getDirectories(path: String): String = Paths.get(path).parent.toString()
}