package lokalize

import lokalize.loader.AbstractLoader
import lokalize.tasks.LoadTask

object Lokalize {
    fun using(loader: AbstractLoader) = LoadTask(loader)
}

