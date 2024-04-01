package ru.itech.sno_api.repository

import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import ru.itech.sno_api.entity.LectureEntity

interface LectureRepository : CrudRepository<LectureEntity, Long>{
    fun findByOrderByLectureId(pageable: Pageable): List<LectureEntity>
}

