package com.hanshinapt.h2h

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [MongoAutoConfiguration::class])
class H2hBackendApplication

fun main(args: Array<String>) {
    runApplication<H2hBackendApplication>(*args)
}
