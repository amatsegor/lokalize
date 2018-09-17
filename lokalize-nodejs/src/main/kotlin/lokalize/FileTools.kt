package lokalize

import Fs
import Mkpath
import Path
import Process

actual object FileTools {
    actual val getCurrentDirectory: String
        get() = Process.cwd() as String

    actual fun isFileExistsSync(filePath: String): Boolean = Fs.existsSync(filePath) as Boolean

    actual fun readFileSync(filePath: String, encoding: String): String = Fs.readFileSync(filePath, encoding) as String

    actual fun writeFileSync(filePath: String, content: String, encoding: String) {
        Fs.writeFileSync(filePath, content, encoding)
    }

    actual fun createPathSync(path: String) {
        Mkpath.sync(path)
    }

    actual fun getDirectories(path: String): String = Path.dirname(path) as String
}