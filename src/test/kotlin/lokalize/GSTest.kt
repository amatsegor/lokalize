package lokalize

import lokalize.models.Options
import lokalize.reader.GSReader
import kotlin.test.Test

class GSTest {

    @Test
    fun testGSLoading() {
        console.log("testGSLoading")

        LokalizeJob.fromGoogleSpreadsheet("1Ej7CiQpGUzbl2Ehb2P2cOpqBzhiWakFKJKW18uakZrw", listOf("*"))
                .save("output/strings.xml", Options("KEY", "android"), "EN")
    }
}