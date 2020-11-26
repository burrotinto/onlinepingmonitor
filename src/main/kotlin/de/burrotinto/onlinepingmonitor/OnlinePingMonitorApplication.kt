package de.burrotinto.onlinepingmonitor

import de.burrotinto.onlinepingmonitor.data.PingRepository
import de.burrotinto.onlinepingmonitor.pinger.Ping
import org.springframework.beans.factory.InitializingBean
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Service
import kotlin.concurrent.thread

@SpringBootApplication
class OnlinePingMonitorApplication

fun main(args: Array<String>) {
    runApplication<OnlinePingMonitorApplication>(*args)
}


@Service
class OnBoot(val ping: Ping, val pingRepository: PingRepository) : InitializingBean {
    override fun afterPropertiesSet() {
//        thread {
//            while (true) {
////                (1 until 100).forEach {
//                    try {
//                        pingRepository.save(
//
//                                ping.pingTarget("192.168.188.1")
//                        )
//                    }catch (e: Exception){}
////                }
//            }
//        }
    }
}