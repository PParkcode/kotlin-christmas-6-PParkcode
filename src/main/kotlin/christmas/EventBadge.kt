package christmas

enum class EventBadge(private val type: String) {
    STAR("별"),
    TREE("트리"),
    SANTA("산타"),
    NOTHING("없음");

    fun getType(): String {
        return type
    }
}