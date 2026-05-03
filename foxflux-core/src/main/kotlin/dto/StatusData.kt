package dto

data class StatusData(
    val versionName: String,
    val protocol: Int,
    val maxPlayers: Int,
    val onlinePlayers: Int,
    val description: String,
    val enforcesSecureChat: Boolean,
    val previewsChat: Boolean
)
