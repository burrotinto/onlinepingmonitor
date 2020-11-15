package de.burrotinto.onlinepingmonitor.ui

import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route

@Route("")
class MainView(pingGrid: PingGrid):VerticalLayout() {
    init {
        addClassName("list-view")
        setSizeFull()

        add(pingGrid)

    }

}