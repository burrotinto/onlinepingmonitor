package de.burrotinto.onlinepingmonitor.data

import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Component
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis


//class BurroTintoPinger(val pingRepository: PingRepository) : InitializingBean {
//    override fun afterPropertiesSet() {
//        thread {
//            while (true) {
//                val time = measureTimeMillis {
//                    val urlObj = URL("161.97.105.198")
//                    val con: HttpURLConnection = urlObj.openConnection() as HttpURLConnection
//                    con.requestMethod = "GET"
//                    con.connectTimeout = 3000
//                    con.connect()
//                }
//
//                pingRepository.add(PingResult(
//                        "burrotinto.de",
//                        time,
//                        System.currentTimeMillis()
//
//                ))
//                Thread.sleep(1000)
//            }
//        }
//    }
//}
