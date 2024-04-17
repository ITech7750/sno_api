package ru.itech.sno_api.entity
import jakarta.persistence.*


@Entity
@Table(name = "forum_participant")
class ForumParticipantEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id")
    val participantId: Long,
    @OneToOne
    @JoinColumn(name = "forum_id")
    var forum: ForumEntity,
    @OneToOne
    @JoinColumn(name = "user_id")
    var user: UserInfoEntity
)
