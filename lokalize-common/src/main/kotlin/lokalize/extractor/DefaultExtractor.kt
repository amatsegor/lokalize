package lokalize.extractor

import lokalize.models.LSArray
import lokalize.models.LSEntity
import lokalize.models.LSLine
import lokalize.models.Worksheet

class DefaultExtractor : Extractor {

    override fun extract(rowLists: List<Worksheet>, keyCol: String, valCol: String): List<LSEntity> {
        if (rowLists.isEmpty()) return listOf()

        val parsedEntities = arrayListOf<LSEntity>()

        rowLists.map { extractFromWorksheet(it, keyCol, valCol) }.forEach { parsedEntities.addAll(it) }

        return parsedEntities
    }

    private fun extractFromWorksheet(worksheet: Worksheet, keyCol: String, valCol: String): List<LSEntity> {
        val results = arrayListOf<LSEntity>()

        var isInArray = false

        var array = LSArray("")

        worksheet.rows.forEach { row ->
            val keyValue = row[keyCol] ?: ""
            val valValue = row[valCol] ?: ""

            when {
                isInArray -> {
                    if (keyValue.matches(arrayStartRegex)) throw IllegalStateException("Array ${array.key} isn't closed")

                    if (keyValue.matches(arrayEndRegex)) {
                        results.add(array)
                        isInArray = false
                    } else {
                        array += LSLine(keyValue, valValue)
                    }
                }

                keyValue.matches(arrayEndRegex) -> throw IllegalStateException("Array closing tag found, but reader is not in array now")

                keyValue.matches(arrayStartRegex) -> {
                    val arrayName = keyValue.substringAfter("[").substringBeforeLast("]")

                    if (arrayName.isBlank()) throw IllegalArgumentException("Array name cannot be empty")

                    array = LSArray(arrayName)

                    isInArray = true
                }

                keyValue.isNotBlank() && valValue.isNotBlank() -> {
                    results.add(LSLine(keyValue, valValue))
                }
            }
        }

        return results
    }

    companion object {
        private val arrayStartRegex = Regex("\\[(\\w+[\\w\\-_])?]")
        private val arrayEndRegex = Regex("\\[/(\\w+[\\w\\-_])+]")
    }
}