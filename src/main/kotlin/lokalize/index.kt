package lokalize

import lokalize.models.Options
import lokalize.reader.GSReader
import lokalize.transformers.AndroidTransformer
import lokalize.writer.FileWriter

fun main(args: Array<String>) {

    val options = Options("KEY", "android")

    val job = LokalizeJob.fromGoogleSpreadsheet("", listOf("*"))
    job.save("results/values/strings.xml", options, "EN")

    /*FileWriter().write("./file.txt", listOf(), AndroidTransformer(), options)

    GSReader("1Ej7CiQpGUzbl2Ehb2P2cOpqBzhiWakFKJKW18uakZrw", listOf("*"))
            .select(listOf(), "", "") {
                console.log(it)
            }*/
}