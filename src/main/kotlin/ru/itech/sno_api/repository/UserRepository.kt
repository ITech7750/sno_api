package ru.itech.sno_api.repository

import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import ru.itech.sno_api.entity.UserEntity
import java.util.*

interface UserRepository : CrudRepository<UserEntity, Long> {
    fun findByEmail(email: String): Optional<UserEntity>

    fun findByOrderByUserId(pageable: Pageable): List<UserEntity>
}


