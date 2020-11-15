package de.burrotinto.onlinepingmonitor.data

interface PingRepository {
    fun add(pingResult: PingResult)
    fun getAll():List<PingResult>
}