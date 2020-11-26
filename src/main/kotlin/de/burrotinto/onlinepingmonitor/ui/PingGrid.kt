package de.burrotinto.onlinepingmonitor.ui

import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.router.Route
import com.vaadin.flow.spring.annotation.SpringComponent
import de.burrotinto.onlinepingmonitor.data.PingResult
import org.springframework.context.annotation.Scope

@SpringComponent
@Scope("vaadin-ui")
@Route("all")
class PingGrid(val pingDataProvider: PingDataProvider) : Grid<PingResult>(PingResult::class.java) {
    init {
        addClassName("PingGrid")
        setSizeFull()
        setColumns("ip", "latenz", "time")


        dataProvider = pingDataProvider

    }


}

