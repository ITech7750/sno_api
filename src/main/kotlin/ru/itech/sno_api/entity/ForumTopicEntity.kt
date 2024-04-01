package ru.itech.sno_api.entity
import jakarta.persistence.*


@Entity
@Table(name = "forum_topic")
class ForumTopicEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    val topicId: Long,
    @OneToOne
    @JoinColumn(name = "forum_id")
    var forum: ForumEntity,
    @Column(name = "title")
    var title: String,
    @Column(name = "description")
    var description: String
)
