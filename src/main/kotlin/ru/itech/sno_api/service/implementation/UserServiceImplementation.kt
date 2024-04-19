package ru.itech.sno_api.service.implementation

import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import ru.itech.sno_api.dto.OrganizationDTO
import ru.itech.sno_api.dto.UserInfoDTO
import ru.itech.sno_api.entity.OrganizationEntity
import ru.itech.sno_api.entity.UserInfoEntity
import ru.itech.sno_api.repository.UserRepository
import ru.itech.sno_api.service.UserService
import org.springframework.data.domain.PageRequest
import ru.itech.sno_api.repository.OrganizationRepository

@Service
class UserServiceImplementation(
    private val userRepository: UserRepository,
    private val organizationRepository: OrganizationRepository,
): UserService {



    /**
     * Получить всех пользователей
     */
    override fun getAll(): List<UserInfoDTO> {
        return userRepository.findAll()
            .map { it.toDTO() }
    }


    /**
     * Получить всех пользователей по странице
     */
    override fun getAllP(pageIndex: Int): List<UserInfoDTO> {
        return userRepository.findByOrderByUserId(PageRequest.of(pageIndex,2))
            .map { it.toDTO() }
    }


    /**
     * Получить пользователя по идентификатору
     */
    override fun getById(userId: Long): UserInfoDTO {
        return userRepository.findById(userId)
            .orElseThrow { throw EntityNotFoundException("User with ID $userId not found") }
            .toDTO()
    }

    /**
     * Создать нового пользователя
     */
    override fun create(user: UserInfoDTO): UserInfoDTO {
        return userRepository.save(user.toEntity())
            .toDTO()
    }

    /**
     * Обновить данные пользователя
     */
    override fun update(userId: Long, user: UserInfoDTO): UserInfoDTO {
        val existingUser = userRepository.findById(userId)
            .orElseThrow { EntityNotFoundException("User with ID $userId not found") }

        existingUser.apply {
            firstName = user.firstName
            lastName = user.lastName
            middleName = user.middleName
            email = user.email
            role = user.role
            isStudentMifi = user.isStudentMifi
            // Проверяем, что organizationId не null
            user.organizationId?.let { organizationId ->
                organization = organization?.let {
                    organizationRepository.findById(it.organizationId)
                        .orElseThrow { EntityNotFoundException("Organization with ID $organizationId not found") }
                }
            }
            twoFactorAuthEnabled = user.twoFactorAuthEnabled
        }

        return userRepository.save(existingUser).toDTO()
    }





    /**
     * Удалить пользователя
     */
    override fun delete(userId: Long) {
        userRepository.deleteById(userId)
    }
}


fun UserInfoEntity.toDTO(): UserInfoDTO {
    return UserInfoDTO(
        firstName = this.firstName,
        lastName = this.lastName,
        middleName = this.middleName,
        login = this.login,
        password = this.password,
        email = this.email,
        role = this.role,
        isStudentMifi = this.isStudentMifi,
        organizationId = this.organization,
        twoFactorAuthEnabled = this.twoFactorAuthEnabled
    )
}


fun UserInfoDTO.toEntity(): UserInfoEntity {
    return UserInfoEntity(
        firstName = this.firstName,
        lastName = this.lastName,
        middleName = this.middleName,
        login = this.login,
        password = this.password,
        email = this.email,
        role = this.role,
        isStudentMifi = this.isStudentMifi,
        organization = this.organizationId,
        twoFactorAuthEnabled = this.twoFactorAuthEnabled
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
