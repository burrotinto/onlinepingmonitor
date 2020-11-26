package de.burrotinto.onlinepingmonitor.pinger

import de.burrotinto.onlinepingmonitor.data.PingResult
import org.springframework.stereotype.Service

@Service
class WindowsPing : Ping {
    override fun pingTarget(target: String): PingResult = pingTarget(target,1).firstOrNull() ?: PingResult(target,time = System.currentTimeMillis())

    override fun pingTarget(target: String, count: Int): List<PingResult> {
        val l = listOf(
                "powershell.exe",
                "Test-Connection",
                "-ComputerName",
                target,
                "-Count",
                count.toString()
        )
        val p = ProcessBuilder(l).start()

        val pings = p.inputStream.bufferedReader()
                .lines()
                .filter { it.contains(target) }
                .map {
                    it.trim().replace("\\s+".toRegex(), " ")
                }
                .map { it.split(" ") }
                .map { PingResult(it[1], it[4].toLong(), System.currentTimeMillis()) }

        return pings.filter { it != null }.iterator().asSequence().toList()
    }

}