package ru.itech.sno_api.entity
import jakarta.persistence.*
import java.util.*


@Entity
@Table(name = "lecture")
class LectureEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    val lectureId: Long,
    @OneToOne
    @JoinColumn(name = "lecturer_id")
    var lecturer: UserInfoEntity,
    @Column(name = "title")
    var title: String,
    @Column(name = "description")
    var description: String,
    @Column(name = "date")
    var date: Date,
    @OneToOne
    @JoinColumn(name = "summary_id")
    var summary: SummaryEntity,
    @OneToOne
    @JoinColumn(name = "forum_id")
    var forum: ForumEntity,
    @OneToOne
    @JoinColumn(name = "file_id")
    var file: FilesEntity
)
