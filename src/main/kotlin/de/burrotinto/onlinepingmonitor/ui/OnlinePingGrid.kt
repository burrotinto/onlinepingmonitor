package de.burrotinto.onlinepingmonitor.ui

import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.data.provider.DataProvider
import com.vaadin.flow.data.provider.Query
import com.vaadin.flow.router.Route
import com.vaadin.flow.spring.annotation.SpringComponent
import de.burrotinto.onlinepingmonitor.data.PingRepository
import de.burrotinto.onlinepingmonitor.data.PingResult
import org.springframework.context.annotation.Scope

@SpringComponent
@Scope("vaadin-ui")
@Route("Online")
class OnlinePingGrid(pingRepository: PingRepository) : Grid<PingResult>(PingResult::class.java) {
    init {
        addClassName("PingGrid")
        setSizeFull()
        setColumns("ip", "latenz", "date")


        dataProvider = DataProvider.fromCallbacks({ query: Query<PingResult, Void> ->
            pingRepository.getAllIPs().mapNotNull { pingRepository.getFirstByIpOrderByTimeDesc(it) }.filter { it.latenz >= 0 }.subList(query.offset, query.offset + query.limit).stream()

        }, {
            pingRepository.getAllIPs().mapNotNull { pingRepository.getFirstByIpOrderByTimeDesc(it) }.filter { it.latenz >= 0 }.size
        })

    }


}

