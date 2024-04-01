package ru.itech.sno_api.service.implementation

import jakarta.persistence.EntityNotFoundException
import ru.itech.sno_api.dto.FilesDTO
import ru.itech.sno_api.entity.FilesEntity
import org.springframework.stereotype.Service
import ru.itech.sno_api.service.FilesService
import ru.itech.sno_api.repository.FilesRepository
@Service
class FilesServiceImplementation(
    private val filesRepository: FilesRepository
): FilesService {

    override fun getAll(): List<FilesDTO> {
        return filesRepository.findAll()
            .map { it.toDTO() }
    }

    override fun getById(fileId: Long): FilesDTO {
        return filesRepository.findById(fileId)
            .orElseThrow { throw EntityNotFoundException("File with ID $fileId not found") }
            .toDTO()
    }

    override fun create(file: FilesDTO): FilesDTO {
        return filesRepository.save(file.toEntity())
            .toDTO()
    }

    override fun update(fileId: Long, file: FilesDTO): FilesDTO {
        val existingFile = filesRepository.findById(fileId)
            .orElseThrow { throw EntityNotFoundException("File with ID $fileId not found") }

        existingFile.filePath = file.filePath
        existingFile.lecture = file.lecture.toEntity()

        return filesRepository.save(existingFile)
            .toDTO()
    }

    override fun delete(fileId: Long) {
        filesRepository.deleteById(fileId)
    }
}

fun FilesEntity.toDTO(): FilesDTO {
    return FilesDTO(
        fileId = fileId,
        filePath = filePath,
        lecture = lecture.toDTO()
    )
}

fun FilesDTO.toEntity(): FilesEntity {
    return FilesEntity(
        fileId = fileId,
        filePath = filePath,
        lecture = lecture.toEntity()
    )
}
