import com.google.inject.Inject
import events.Tick
import model.entity.World
import repository.IWorldRepository
import repository.WorldRepository
import java.util.concurrent.ConcurrentHashMap

class TickEngine @Inject constructor(var worldRepository: IWorldRepository) {
    val tickEvent: MutableSet<Tick> = ConcurrentHashMap.newKeySet()
    fun start() {
        //Позже
        tickEvent.forEach {
            it.tick()
            tickEvent.remove(it)
        }
    }
}