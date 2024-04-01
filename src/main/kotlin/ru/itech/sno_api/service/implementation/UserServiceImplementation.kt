package ru.itech.sno_api.service.implementation

import jakarta.persistence.EntityNotFoundException
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import ru.itech.sno_api.dto.OrganizationDTO
import ru.itech.sno_api.dto.UserDTO
import ru.itech.sno_api.entity.OrganizationEntity
import ru.itech.sno_api.entity.UserEntity
import ru.itech.sno_api.repository.UserRepository
import ru.itech.sno_api.service.UserService
import org.springframework.data.domain.PageRequest

@Service
class UserServiceImplementation(
    private val userRepository: UserRepository
): UserService {

    /**
     * Получить всех пользователей
     */
    override fun getAll(): List<UserDTO> {
        return userRepository.findAll()
            .map { it.toDTO() }
    }


    /**
     * Получить всех пользователей по странице
     */
    override fun getAllP(pageIndex: Int): List<UserDTO> {
        return userRepository.findByOrderByUserId(PageRequest.of(pageIndex,2))
            .map { it.toDTO() }
    }


    /**
     * Получить пользователя по идентификатору
     */
    override fun getById(userId: Long): UserDTO {
        return userRepository.findById(userId)
            .orElseThrow { throw EntityNotFoundException("User with ID $userId not found") }
            .toDTO()
    }

    /**
     * Создать нового пользователя
     */
    override fun create(user: UserDTO): UserDTO {
        return userRepository.save(user.toEntity())
            .toDTO()
    }

    /**
     * Обновить данные пользователя
     */
    override fun update(userId: Long, user: UserDTO): UserDTO {
        val existingUser = userRepository.findById(userId)
            .orElseThrow { throw EntityNotFoundException("User with ID $userId not found") }

        existingUser.firstName = user.firstName
        existingUser.lastName = user.lastName
        existingUser.middleName = user.middleName
        existingUser.email = user.email
        existingUser.role = user.role
        existingUser.isStudentMifi = user.isStudentMifi
        existingUser.organization = user.organization.toEntity()
        existingUser.twoFactorAuthEnabled = user.twoFactorAuthEnabled

        return userRepository.save(existingUser)
            .toDTO()
    }

    /**
     * Удалить пользователя
     */
    override fun delete(userId: Long) {
        userRepository.deleteById(userId)
    }
}


fun UserEntity.toDTO(): UserDTO {
    return UserDTO(
        userId = userId,
        firstName = firstName,
        lastName = lastName,
        middleName = middleName,
        email = email,
        role = role,
        isStudentMifi = isStudentMifi,
        organization = organization.toDTO(),
        twoFactorAuthEnabled = twoFactorAuthEnabled
    )
}

fun UserDTO.toEntity(): UserEntity {
    return UserEntity(
        userId = userId,
        firstName = firstName,
        lastName = lastName,
        middleName = middleName,
        email = email,
        role = role,
        isStudentMifi = isStudentMifi,
        organization = organization.toEntity(),
        twoFactorAuthEnabled = twoFactorAuthEnabled
    )
}

fun OrganizationEntity.toDTO(): OrganizationDTO {
    return OrganizationDTO(
        organizationId = organizationId,
        university = university,
        faculty = faculty,
        groupName = groupName,
        isSoftDeleted = isSoftDeleted
    )
}

fun OrganizationDTO.toEntity(): OrganizationEntity {
    return OrganizationEntity(
        organizationId = organizationId,
        university = university,
        faculty = faculty,
        groupName = groupName,
        isSoftDeleted = isSoftDeleted
    )
}
