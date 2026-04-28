import events.Tick
import java.util.concurrent.ConcurrentHashMap
import kotlin.concurrent.fixedRateTimer

class TickEngine {
    val tickEvent: MutableSet<Tick> = ConcurrentHashMap.newKeySet()
    fun start() {
        fixedRateTimer("Tick", true, 0, period = 50L) {
            tickEvent.forEach {
                it.tick()
            }
        }
    }

    fun addEvent(event: Tick) {
        tickEvent.add(event)
    }
}