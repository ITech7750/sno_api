package ru.itech.sno_api.repository

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.itech.sno_api.entity.UserEntity
import java.util.*

@Repository
@EnableJpaRepositories
@EntityScan
interface UserRepository : CrudRepository<UserEntity, Long> {
    fun findByEmail(email: String): Optional<UserEntity>

    fun findByLogin(login: String): Optional<UserEntity>

    fun findByOrderByUserId(pageable: Pageable): List<UserEntity>

    fun save(entity: UserEntity): UserEntity

}
