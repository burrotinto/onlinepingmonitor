package de.burrotinto.onlinepingmonitor.data


import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class PingResult(val ip: String = "", val latenz: Long = -1L, val time: Long = -1L, val date: String = convertLongToTime(time)) : Serializable {
    @Id
    @GeneratedValue
    private val id: Long? = null
}

fun convertLongToTime(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("dd.MM.yyyy HH:mm:ss")
    return format.format(date)
}

fun currentTimeToLong(): Long {
    return System.currentTimeMillis()
}

fun convertDateToLong(date: String): Long {
    val df = SimpleDateFormat("dd.MM.yyyy HH:mm:ss")
    return df.parse(date).time
}