package lokalize.tasks

import lokalize.loader.AbstractLoader
import lokalize.models.Options

class LoadTask(private val loader: AbstractLoader) {
    suspend fun load(options: Options) = ExtractTask(loader.load(), options)
}