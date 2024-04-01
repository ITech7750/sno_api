package ru.itech.sno_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SnoApiApplication

fun main(args: Array<String>) {
    runApplication<SnoApiApplication>(*args)
}
