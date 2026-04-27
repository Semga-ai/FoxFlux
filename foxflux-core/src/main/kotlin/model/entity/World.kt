package model.entity

import events.Tick
import other.Event
import java.util.Queue
import java.util.concurrent.ConcurrentLinkedQueue

data class World (
    var events_queue: Queue<Event> = ConcurrentLinkedQueue()
) : Tick {
    override fun tick() {
        events_queue.forEach {e ->
            e.onTick()
            events_queue.remove(e)
        }
    }
    fun addEvent(event: Event) {
        events_queue.add(event)
    }
}
