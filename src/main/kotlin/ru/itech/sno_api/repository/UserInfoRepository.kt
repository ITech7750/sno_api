package ru.itech.sno_api.repository

import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import ru.itech.sno_api.entity.UserEntity
import ru.itech.sno_api.entity.UserInfoEntity
import java.util.*

interface UserInfoRepository : CrudRepository<UserInfoEntity, Long> {


    fun findByOrderByUserId(pageable: Pageable): List<UserInfoEntity>

    fun save(entity: UserEntity): UserEntity

}


