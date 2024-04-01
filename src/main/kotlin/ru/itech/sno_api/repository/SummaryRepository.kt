package ru.itech.sno_api.repository

import org.springframework.data.repository.CrudRepository
import ru.itech.sno_api.entity.SummaryEntity

interface SummaryRepository : CrudRepository<SummaryEntity, Long>
