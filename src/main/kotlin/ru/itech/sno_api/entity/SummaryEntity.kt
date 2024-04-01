package ru.itech.sno_api.entity
import jakarta.persistence.*


@Entity
@Table(name = "summary")
class SummaryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "summary_id")
    val summaryId: Long,
    @Column(name = "title")
    var title: String,
    @Column(name = "description")
    var description: String
)
