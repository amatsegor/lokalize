package lokalize.tasks

import lokalize.loader.AbstractLoader
import lokalize.models.Options

class LoadTask(private val loader: AbstractLoader) {

    suspend fun load(options: Options): ExtractTask {
        return ExtractTask(loader.load(), options)

        /*loader.load()
                .then {
                    if (it.isNotEmpty()) {
                        val transformer = TransformerFactory.create(opts.format)
                        writer.write(outputPath, it, transformer, opts)
                    } else {
                        console.log("No lines detected")
                    }
                }.catch {
                    console.log(it)
                }*/


    }
}