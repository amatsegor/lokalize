package lokalize

expect object FileTools {
    val getCurrentDirectory: String

    fun isFileExistsSync(filePath: String): Boolean

    fun readFileSync(filePath: String, encoding: String): String

    fun writeFileSync(filePath: String, content: String, encoding: String)

    fun createPathSync(path: String)

    fun getDirectories(path: String): String
}