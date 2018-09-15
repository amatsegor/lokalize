package lokalize.loader

import lokalize.models.Worksheet

abstract class AbstractLoader {
    abstract suspend fun load(): List<Worksheet>
}