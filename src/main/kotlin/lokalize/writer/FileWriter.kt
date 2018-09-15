package lokalize.writer

import Fs
import Mkpath
import Path
import Process
import lokalize.models.LSEntity
import lokalize.models.Options
import lokalize.transformers.AbstractTransformer

class FileWriter : AbstractWriter() {
    override fun write(path: String, entities: List<LSEntity>, transformer: AbstractTransformer, options: Options) {
        var fileContent = ""

        val currentFolder = Process.cwd()
        val filePath = "$currentFolder/$path"

        console.log("Writing file $filePath")

        if (Fs.existsSync(filePath)) {
            fileContent = Fs.readFileSync(path, options.encoding)
        }

        val toInsert = transformer.transform(entities)
        val output = transformer.insert(fileContent, toInsert, options)

        writeFileAndCreateDirectoriesSync(filePath, output)
    }

    private fun writeFileAndCreateDirectoriesSync(filepath: String, content: String, encoding: String = "utf8") {
        val dirname = Path.dirname(filepath)
        Mkpath.sync(dirname)

        Fs.writeFileSync(filepath, content, encoding)
    }
}