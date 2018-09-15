package lokalize

import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import lokalize.models.Options

fun main(args: Array<String>) {

    val options = Options("KEY", "android")

    GlobalScope.launch {
        Lokalize.fromGoogleSpreadsheet("1rVIuMUuuJcZNLmAnCRosxOqiZJ-jtRqBz2rkDXvFG8w", "Sheet1")
                .load(options)
                .extract("EN", "output/values/strings.xml")
                .extract("ES", "output/values-es/strings.xml")
                .extract("BG", "output/values-bg/strings.xml")
                .extract("LT", "output/values-lt/strings.xml")
                .extract("LV", "output/values-lv/strings.xml")
                .transform()
                .save()
    }
}