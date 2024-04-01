package ru.itech.sno_api.service

import org.springframework.stereotype.Service
import ru.itech.sno_api.dto.FilesDTO

@Service
interface FilesService {

    fun getAll(): List<FilesDTO>

    fun getById(fileId: Long): FilesDTO

    fun create(file: FilesDTO): FilesDTO

    fun update(fileId: Long, file: FilesDTO): FilesDTO

    fun delete(fileId: Long)
}
