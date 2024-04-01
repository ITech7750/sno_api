package ru.itech.sno_api.entity
import jakarta.persistence.*
import java.sql.Timestamp


@Entity
@Table(name = "forum_Message")
class ForumMessageEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    val messageId: Long,
    @OneToOne
    @JoinColumn(name = "topic_id")
    var topic: ForumTopicEntity,
    @OneToOne
    @JoinColumn(name = "user_id")
    var user: UserEntity,
    @Column(name = "reply_id")
    var replyId: Long,
    @Column(name = "message_text")
    var messageText: String,
    @Column(name = "timestamp")
    var timestamp: Timestamp
)
