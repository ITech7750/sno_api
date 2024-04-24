package ru.itech.sno_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class VideoStreamApplication

fun main(args: Array<String>) {
    runApplication<VideoStreamApplication>(*args)
}
