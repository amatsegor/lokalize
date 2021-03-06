package lokalize.transformer

import lokalize.models.*

abstract class AbstractTransformer {

    open fun transformArray(array: LSArray): String = ""

    open fun transformPlural(plural: LSPlural): String = ""

    abstract fun transformComment(comment: String): String

    abstract fun transformKeyValue(key: String, value: String, closing: Boolean): String

    abstract fun insert(input: String?, newValues: String, options: Options): String

    fun transform(entities: List<LSEntity>): String {
        val valueToInsert = StringBuilder()

        val nonEmptyEntities = entities.filter { entity -> !entity.isEmpty }

        nonEmptyEntities
                .sortedWith(ENTITY_COMPARATOR)
                .forEachIndexed { index, entity ->
                    var skipped = false

                    val isClosing = index == nonEmptyEntities.size - 1

                    when (entity) {
                        is LSLine -> {
                            if (entity.isComment) {
                                valueToInsert.append(transformComment(entity.value))
                            } else {
                                valueToInsert.append(transformKeyValue(entity.key, entity.value, isClosing))
                            }
                        }
                        is LSArray -> {
                            val transformedArray = transformArray(entity)

                            if (transformedArray.isBlank()) {
                                skipped = true
                            } else {
                                valueToInsert.append(transformedArray)
                            }
                        }
                        is LSPlural -> {
                            val transformedPlural = transformPlural(entity)

                            if (transformedPlural.isBlank()) {
                                skipped = true
                            } else {
                                valueToInsert.append(transformedPlural)
                            }
                        }
                    }

                    if (!isClosing && !skipped) {
                        valueToInsert.append('\n')
                    }
                }
        return valueToInsert.toString()
    }

    abstract val autogeneratedTag: String

    companion object {
        private val ENTITY_COMPARATOR = Comparator<LSEntity> { e1, e2 ->
            return@Comparator if (e1 is LSArray) {
                if (e2 is LSArray) 0 else -1
            } else {
                if (e2 is LSArray) 1 else 0
            }
        }
    }
}