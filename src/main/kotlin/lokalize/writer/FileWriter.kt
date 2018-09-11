package lokalize.writer

import Fs
import Process
import lokalize.models.LSEntity
import lokalize.models.Options
import lokalize.transformers.AbstractTransformer

class FileWriter : AbstractWriter() {
    override fun write(path: String, lines: List<LSEntity>, transformer: AbstractTransformer, options: Options) {
        var fileContent = ""

        println("Current directory: ${Process.cwd()}")

        if (Fs.existsSync(path)) {
            fileContent = Fs.readFileSync(path, options.encoding)
        } else {
            println("File doesn't exist: $path")
        }

        println(fileContent)
    }
}