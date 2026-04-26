import events.Tick
import java.util.concurrent.ConcurrentHashMap

class TickEngine {
    var subscribers: MutableSet<Tick> = ConcurrentHashMap.newKeySet()

}