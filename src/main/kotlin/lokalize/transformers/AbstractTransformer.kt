package lokalize.transformers

import lokalize.models.LSArray
import lokalize.models.Options

abstract class AbstractTransformer {
    abstract fun transformArray(array: LSArray): String

    abstract fun transformComment(comment: String): String

    abstract fun transformKeyValue(key: String, value: String): String

    abstract fun insert(input: String, newValues: String, options: Options): String
}