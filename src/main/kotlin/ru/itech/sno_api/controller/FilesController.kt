package ru.itech.sno_api.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*
import ru.itech.sno_api.dto.FilesDTO
import ru.itech.sno_api.service.FilesService

@RestController
@RequestMapping("/api/v1/files")
@Tag(
    name = "Files API",
    description = "Файлы"
)
class FilesController(
    private val filesService: FilesService
) {

    @Operation(method = "Получение всех файлов")
    @GetMapping
    fun getAll(): List<FilesDTO> =
        filesService.getAll()

    @Operation(method = "Получение файла по идентификатору")
    @GetMapping("/{fileId}")
    fun getById(@PathVariable fileId: Long): FilesDTO =
        filesService.getById(fileId)

    @Operation(method = "Создание нового файла")
    @PostMapping
    fun create(@RequestBody file: FilesDTO): FilesDTO =
        filesService.create(file)

    @Operation(method = "Обновление данных файла")
    @PutMapping("/{fileId}")
    fun update(@PathVariable fileId: Long, @RequestBody file: FilesDTO): FilesDTO =
        filesService.update(fileId, file)

    @Operation(method = "Удаление файла")
    @DeleteMapping("/{fileId}")
    fun delete(@PathVariable fileId: Long) =
        filesService.delete(fileId)
}
