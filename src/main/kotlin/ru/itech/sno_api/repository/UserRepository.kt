package ru.itech.sno_api.repository

import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import ru.itech.sno_api.entity.UserInfoEntity
import java.util.*

interface UserRepository : CrudRepository<UserInfoEntity, Long> {
    fun findByEmail(email: String): Optional<UserInfoEntity>

    fun findByOrderByUserId(pageable: Pageable): List<UserInfoEntity>
}


