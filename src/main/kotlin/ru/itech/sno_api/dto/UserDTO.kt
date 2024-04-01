package ru.itech.sno_api.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Пользователь")
data class UserDTO(
    @Schema(description = "Идентификатор пользователя")
    val userId: Long,
    @Schema(description = "Имя")
    val firstName: String,
    @Schema(description = "Фамилия")
    val lastName: String,
    @Schema(description = "Отчество")
    val middleName: String,
    @Schema(description = "Электронная почта")
    val email: String,
    @Schema(description = "Роль")
    val role: String,
    @Schema(description = "Студент МИФИ")
    val isStudentMifi: Boolean,
    @Schema(description = "Организация")
    val organization: OrganizationDTO,
    @Schema(description = "Двухфакторная аутентификация")
    val twoFactorAuthEnabled: Boolean
)
