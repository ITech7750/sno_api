package ru.itech.sno_api.entity
import jakarta.persistence.*

@Entity
@Table(name = "user_table")
data class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val userId: Long = 0,

    @Column(unique = true)
    val login: String,

    val password: String,

    val email: String
)
