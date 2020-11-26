package de.burrotinto.onlinepingmonitor.ui

import com.vaadin.flow.data.provider.DataProvider
import com.vaadin.flow.data.provider.Query
import de.burrotinto.onlinepingmonitor.data.PingRepository
import de.burrotinto.onlinepingmonitor.data.PingResult
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component
import java.util.stream.Stream

@Component
class PingDataProvider(val pingRepository: PingRepository) : DataProvider<PingResult, Void>
by DataProvider.fromCallbacks({ query: Query<PingResult, Void> ->
    pingRepository.findAll(PageRequest.of(query.offset, query.limit))?.stream() ?: Stream.empty()

}, {
    pingRepository.count().toInt()
})