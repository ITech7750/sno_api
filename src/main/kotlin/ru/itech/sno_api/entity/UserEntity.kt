package ru.itech.sno_api.entity

import jakarta.persistence.*

@Entity
@Table(name = "user")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val userId: Long,
    @Column(name = "first_name")
    var firstName: String,
    @Column(name = "last_name")
    var lastName: String,
    @Column(name = "middle_name")
    var middleName: String,
    @Column(name = "email")
    var email: String,
    @Column(name = "role")
    var role: String,
    @Column(name = "is_student_mifi")
    var isStudentMifi: Boolean,
    @OneToOne
    @JoinColumn(name = "organization_id")
    var organization: OrganizationEntity,
    @Column(name = "two_factor_auth_enabled")
    var twoFactorAuthEnabled: Boolean
)
