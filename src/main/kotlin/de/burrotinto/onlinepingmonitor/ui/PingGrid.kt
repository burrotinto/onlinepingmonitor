package de.burrotinto.onlinepingmonitor.ui

import com.vaadin.flow.component.UI
import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.spring.annotation.SpringComponent
import com.vaadin.flow.spring.annotation.VaadinSessionScope
import de.burrotinto.onlinepingmonitor.data.PingRepository
import de.burrotinto.onlinepingmonitor.data.PingResult
import org.springframework.context.annotation.Scope
import kotlin.concurrent.thread

@SpringComponent
@Scope("vaadin-ui")
class PingGrid(val pingRepository: PingRepository) : Grid<PingResult>(PingResult::class.java) {
    init {
        addClassName("PingGrid")
        setSizeFull()
        setColumns("ip", "latenz", "time")

        thread {
            if (pingRepository.getAll().isNotEmpty()) {
                setItems(pingRepository.getAll())
            }
            Thread.sleep(1000)
            UI.getCurrent().page.reload()
        }

    }


}