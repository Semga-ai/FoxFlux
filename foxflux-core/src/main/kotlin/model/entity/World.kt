package model.entity

import other.Event
import java.util.Queue
import java.util.concurrent.ConcurrentLinkedQueue

data class World(
    var events_queue: Queue<Event> = ConcurrentLinkedQueue()
) {
    fun onTick() {
        events_queue.forEach {e ->
            e.onTick()
        }
    }

    fun addEvent(event: Event) {
        events_queue.add(event)
    }
}
