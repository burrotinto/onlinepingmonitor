package de.burrotinto.onlinepingmonitor.data


import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository


interface PingRepository : CrudRepository<PingResult, Long> {
    fun findAll(pageable: Pageable): Page<PingResult>?
    fun getFirstByIpOrderByTimeDesc(ip: String): PingResult?

    @Query("select distinct p.ip from #{#entityName} p")
    fun getAllIPs(): List<String>
}