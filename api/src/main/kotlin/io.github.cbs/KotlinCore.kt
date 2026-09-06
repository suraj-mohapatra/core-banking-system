package io.github.cbs

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinCore

private val log = LoggerFactory.getLogger(KotlinCore::class.java)

fun main(args: Array<String>) {
    runApplication<KotlinCore>(*args)
    log.info("cbs started ----------------------------------------------------------------------------------------------------------------------------"
    .trimIndent())
}
