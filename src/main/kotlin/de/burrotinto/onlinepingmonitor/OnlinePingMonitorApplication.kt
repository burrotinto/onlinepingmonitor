package de.burrotinto.onlinepingmonitor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OnlinePingMonitorApplication

fun main(args: Array<String>) {
    runApplication<OnlinePingMonitorApplication>(*args)
}
