package ru.itech.sno_api.entity
import jakarta.persistence.*

@Entity
@Table(name = "forum")
class ForumEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "forum_id")
    var forumId: Long = 0,

    @Column(name = "title", nullable = false, length = 255)
    var title: String,

    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    var description: String
) {
    override fun toString(): String {
        return "ForumEntity(forumId=$forumId, title='$title', description=$description)"
    }
}