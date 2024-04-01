package ru.itech.sno_api.entity
import jakarta.persistence.*

@Entity
@Table(name = "forum")
class ForumEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "forum_id")
    val forumId: Long,
    @Column(name = "title")
    var title: String,
    @Column(name = "description")
    var description: String
)
