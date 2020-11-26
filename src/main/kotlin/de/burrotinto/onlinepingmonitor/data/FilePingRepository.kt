package de.burrotinto.onlinepingmonitor.data

import org.springframework.stereotype.Component
import java.io.File
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.read
import kotlin.concurrent.write


//@Component
//class FilePingRepository(private val file: File = File("./pingRepository.csv")) : PingRepository {
//    private val lock = ReentrantReadWriteLock()
//
//    override fun add(pingResult: PingResult) {
//        lock.write {
//            file.appendText("${pingResult.ip};${pingResult.latenz};${pingResult.time}")
//        }
//    }
//
//    override fun getAll(): List<PingResult> =
//            lock.read {
//                file.readLines()
//                        .map { it.split(";") }
//                        .map { PingResult(it[0], it[1].toLong(), it[2].toLong()) }
//            }
//}