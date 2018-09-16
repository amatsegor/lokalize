package lokalize.models

data class Options(
    val keyCol: String,
    val format: String,
    val valueCol: String = "",
    val encoding: String = "utf-8",
    val className: String? = null,
    val baseClass: String? = null,
    val header: String? = null,
    val footer: String? = null
)