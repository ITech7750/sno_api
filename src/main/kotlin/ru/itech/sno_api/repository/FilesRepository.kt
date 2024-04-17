package ru.itech.sno_api.repository


import org.springframework.data.jpa.repository.JpaRepository
import ru.itech.sno_api.entity.FilesEntity

interface FilesRepository : JpaRepository<FilesEntity, Long>
