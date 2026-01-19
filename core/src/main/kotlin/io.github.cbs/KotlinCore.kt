package io.github.cbs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinCore

fun main(args: Array<String>) {
    runApplication<KotlinCore>(*args)
    println("started in KotlinMain")
}
