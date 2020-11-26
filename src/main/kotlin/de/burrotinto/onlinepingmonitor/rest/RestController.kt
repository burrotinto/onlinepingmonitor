package de.burrotinto.onlinepingmonitor.rest

import de.burrotinto.onlinepingmonitor.data.PingRepository
import de.burrotinto.onlinepingmonitor.data.PingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong


@RestController
class PingController(val pingRepository: PingRepository) {
    private val counter = AtomicLong()

    @PostMapping("V1/ping")
    fun greeting(@RequestParam(value = "ip") ip: String,
                 @RequestParam(value = "latenz") latenz: Long,
                 @RequestParam(value = "time") time: Long?) {
        pingRepository.save(PingResult(ip, latenz, time ?: System.currentTimeMillis()))
    }

}