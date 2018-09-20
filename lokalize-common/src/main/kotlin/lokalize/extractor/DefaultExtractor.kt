package lokalize.extractor

import lokalize.models.LSArray
import lokalize.models.LSEntity
import lokalize.models.LSLine
import lokalize.models.Worksheet

class DefaultExtractor : Extractor {

    private var currentArray = LSArray("")
    private var isInArray = false

    override fun extract(rowLists: List<Worksheet>, keyCol: String, valCol: String): List<LSEntity> {
        if (rowLists.isEmpty()) return listOf()

        val parsedEntities = arrayListOf<LSEntity>()

        rowLists.map { extractFromWorksheet(it, keyCol, valCol) }.forEach { parsedEntities.addAll(it) }

        return parsedEntities
    }

    private fun extractFromWorksheet(worksheet: Worksheet, keyCol: String, valCol: String): List<LSEntity> {
        val results = arrayListOf<LSEntity>()

        worksheet.rows.forEach { row ->
            val keyValue = row[keyCol] ?: ""
            val valValue = row[valCol] ?: ""

            when {
                isInArray -> addValueToArray(keyValue, valValue, results)

                keyValue.matches(arrayEndRegex) -> throw IllegalStateException("Array closing tag found, but reader is not in array now")

                keyValue.matches(arrayStartRegex) -> {
                    val arrayName = keyValue.substringAfter("[").substringBeforeLast("]")

                    if (arrayName.isBlank()) throw IllegalArgumentException("Array name cannot be empty")

                    currentArray = LSArray(arrayName)

                    isInArray = true
                }

                keyValue.isNotBlank() -> results.add(LSLine(keyValue, valValue))
            }
        }

        return results
    }

    private fun addValueToArray(key: String, value: String, target: MutableList<LSEntity>) {
        if (key.matches(arrayStartRegex)) throw IllegalStateException("Array ${currentArray.key} isn't closed")

        if (key.matches(arrayEndRegex)) {
            target.add(currentArray)
            isInArray = false
        } else {
            currentArray += LSLine(key, value)
        }
    }

    companion object {
        private val arrayStartRegex = Regex("\\[(\\w+[\\w\\-_])?]")
        private val arrayEndRegex = Regex("\\[/(\\w+[\\w\\-_])+]")
    }
}