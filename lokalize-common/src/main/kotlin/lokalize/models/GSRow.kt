package lokalize.models

class GSRow(private val keyValue: List<Pair<String, String>>) {
    operator fun get(key: String): String? = keyValue.firstOrNull { it.first == key.toLowerCase() }?.second ?: ""
}