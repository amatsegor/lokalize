package lokalize.extractor

import lokalize.models.*

class DefaultExtractor : Extractor {

    private var currentPlural = LSPlural("")
    private var isInPlural = false

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

            val shouldOpenArray = keyValue.matches(arrayStartRegex)
            val shouldCloseArray = keyValue.matches(arrayEndRegex)

            val shouldOpenPlural = keyValue.matches(pluralStartRegex)
            val shouldClosePlural = keyValue.matches(pluralEndRegex)

            when {
                isInArray -> {
                    if (shouldOpenArray) throw IllegalStateException("Array ${currentArray.key} isn't closed")

                    if (shouldCloseArray) {
                        closeArray(results)
                    } else {
                        currentArray += LSLine(keyValue, valValue)
                    }
                }

                shouldCloseArray -> throw IllegalStateException("Array closing tag found, but reader is not in array now")
                shouldOpenArray -> {
                    if (isInPlural) throw IllegalStateException("Array opening tag found while plural ${currentPlural.key} isn't closed")
                    createArray(keyValue)
                }

                isInPlural -> {
                    if (shouldOpenPlural) throw IllegalStateException("Plural ${currentPlural.key} isn't closed")

                    if (shouldClosePlural) {
                        closePlural(results)
                    } else {
                        if (LSPlural.Quantifier.isQuantifierValid(keyValue)) {
                            currentPlural += LSLine(keyValue, valValue)
                        } else {
                            throw IllegalArgumentException("Invalid plural quantifier: $keyValue")
                        }
                    }
                }

                shouldClosePlural -> throw IllegalStateException("Plural closing tag found, but reader is not in plural now")
                shouldOpenPlural -> {
                    if (isInArray) throw IllegalStateException("Plural opening tag found while array ${currentArray.key} isn't closed")
                    createPlural(keyValue)
                }

                keyValue.isNotBlank() -> results.add(LSLine(keyValue, valValue))
            }
        }

        return results
    }

    private fun createArray(key: String) {
        val arrayName = key.substringAfter("[").substringBeforeLast("]")

        if (arrayName.isBlank()) throw IllegalArgumentException("Array name cannot be empty")

        currentArray = LSArray(arrayName)

        isInArray = true
    }

    private fun closeArray(target: MutableList<LSEntity>) {
        target.add(currentArray)
        isInArray = false
    }

    private fun createPlural(key: String) {
        val arrayName = key.substringBeforeLast(".")

        if (arrayName.isBlank()) throw IllegalArgumentException("Plural name cannot be empty")

        currentPlural = LSPlural(arrayName)

        isInPlural = true
    }

    private fun closePlural(target: MutableList<LSEntity>) {
        target.add(currentPlural)
        isInPlural = false
    }

    companion object {
        private val arrayStartRegex = Regex("\\[(\\w+[\\w\\-_])?]")
        private val arrayEndRegex = Regex("\\[/(\\w+[\\w\\-_])+]")

        private val pluralStartRegex = Regex("\\w+.plural")
        private val pluralEndRegex = Regex("!\\w+.plural")
    }
}