package ru.itech.sno_api.entity
import jakarta.persistence.*


@Entity
@Table(name = "files")
class FilesEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    val fileId: Long,
    @Column(name = "file_path")
    var filePath: String,
    @OneToOne
    @JoinColumn(name = "lecture_id")
    var lecture: LectureEntity
)