package ru.itech.sno_api.repository

import org.springframework.data.repository.CrudRepository
import ru.itech.sno_api.entity.AuthorizationEntity

interface AuthorizationRepository : CrudRepository<AuthorizationEntity, Long>
