package lokalize.loader

import lokalize.models.Worksheet

class FakeLoader : AbstractLoader() {

    override suspend fun load(): List<Worksheet> {
        return listOf()
    }
}