package lokalize.transformers

import lokalize.models.LSArray
import lokalize.models.LSEntity
import lokalize.models.LSLine
import lokalize.models.Options

abstract class AbstractTransformer {
    abstract fun transformArray(array: LSArray): String

    abstract fun transformComment(comment: String): String

    abstract fun transformKeyValue(key: String, value: String): String

    abstract fun insert(input: String?, newValues: String, options: Options): String

    fun transform(entities: List<LSEntity>): String {
        val valueToInsert = StringBuilder()

        entities.asSequence()
                .filter { entity -> !entity.isEmpty }
                .forEachIndexed { index, entity ->
                    if (entity is LSLine) {
                        if (entity.isComment) {
                            valueToInsert.append(transformComment(entity.value))
                        } else {
                            valueToInsert.append(transformKeyValue(entity.key, entity.value))
                        }
                    } else if (entity is LSArray) {
                        valueToInsert.append(transformArray(entity))
                    }
                    if (index != entities.size - 1) {
                        valueToInsert.append('\n')
                    }
                }
        return valueToInsert.toString()
    }
}