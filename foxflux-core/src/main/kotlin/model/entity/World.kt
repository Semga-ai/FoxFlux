package model.entity

import events.Tick
import IAbstractEvent
import java.util.Queue
import java.util.concurrent.ConcurrentLinkedQueue

data class World (
    var events_queue: Queue<IAbstractEvent> = ConcurrentLinkedQueue()
) : Tick {
    override fun tick() {
        events_queue.forEach {e ->
            e.onTick()
            events_queue.remove(e)
        }
    }
    fun addEvent(event: IAbstractEvent) {
        events_queue.add(event)
    }
}
