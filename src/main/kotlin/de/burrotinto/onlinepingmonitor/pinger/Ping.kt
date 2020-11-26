package de.burrotinto.onlinepingmonitor.pinger

import de.burrotinto.onlinepingmonitor.data.PingResult

interface Ping {
    fun pingTarget(target: String): PingResult
    fun pingTarget(target: String, count : Int): List<PingResult>
}