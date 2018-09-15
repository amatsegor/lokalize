package lokalize.models

data class Options(
    val keyCol: String,
    val format: String,
    val valueCol: String = "",
    val encoding: String = "utf-8",
    val className: String = "",
    val baseClass: String = "",
    val header: String = "",
    val footer: String = ""
)