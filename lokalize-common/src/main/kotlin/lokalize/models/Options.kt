package lokalize.models

data class Options(
    val keyCol: String?,
    val format: String?,
    var encoding: String? = "utf-8",
    val className: String? = null,
    val baseClass: String? = null,
    val header: String? = null,
    val footer: String? = null
)