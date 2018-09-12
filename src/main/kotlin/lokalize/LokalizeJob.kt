package lokalize

import lokalize.models.Options
import lokalize.reader.AbstractReader
import lokalize.reader.GSReader
import lokalize.transformers.TransformerFactory
import lokalize.writer.AbstractWriter
import lokalize.writer.FileWriter



class LokalizeJob(private val reader: AbstractReader, private val writer: AbstractWriter) {

    fun save(outputPath: String, opts: Options, valueCol: String? = null) {
        console.log("saving $outputPath")

        val valCol = valueCol ?: opts.valueCol

        reader.select(listOf(), opts.keyCol, valCol)
                .then {
                    if (it != null) {
                        val transformer = TransformerFactory.create(opts.format)
                        writer.write(outputPath, it, transformer, opts)
                    } else {
                        console.log("No lines detected")
                    }
                }
    }

    companion object {
        fun fromGoogleSpreadsheet(spreadsheetKey: String, sheets: List<String>): LokalizeJob {
            val fileWriter = FileWriter()
            return LokalizeJob(GSReader(spreadsheetKey, sheets), fileWriter)
        }
    }
}