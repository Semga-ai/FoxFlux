import com.google.inject.Inject
import events.Tick
import model.entity.World
import repository.IWorldRepository
import repository.WorldRepository
import java.util.concurrent.ConcurrentHashMap
import kotlin.concurrent.fixedRateTimer

class TickEngine @Inject constructor(var worldRepository: IWorldRepository) {
    val tickEvent: MutableSet<Tick> = ConcurrentHashMap.newKeySet()
    fun start() {
        fixedRateTimer("Tick", true, 0, period = 50L) {
            tickEvent.forEach {
                it.tick()
                tickEvent.remove(it)
            }
        }
    }
}