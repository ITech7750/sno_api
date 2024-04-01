package ru.itech.sno_api.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.util.*


@Schema(description = "Лекция")
data class LectureDTO(
    @Schema(description = "Идентификатор лекции")
    val lectureId: Long,
    @Schema(description = "Лектор")
    val lecturer: UserDTO,
    @Schema(description = "Название")
    val title: String,
    @Schema(description = "Описание")
    val description: String,
    @Schema(description = "Дата")
    val date: Date,
    @Schema(description = "Конспект")
    val summary: SummaryDTO,
    @Schema(description = "Форум")
    val forum: ForumDTO
)
