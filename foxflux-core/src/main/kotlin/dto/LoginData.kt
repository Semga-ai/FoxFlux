package dto

import java.util.UUID

data class LoginData(
    val username: String,
    val uuid: UUID,
    val propertiesCount : Int,
    val StrictErrorHandling : Boolean
)
