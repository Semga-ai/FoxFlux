import kotlin.enums.EnumEntries
import kotlin.reflect.KClass

data class Client(
    val state: EnumEntries<ConnectionStates> = ConnectionStates.entries,
    val registry: PacketRegistry
) {
    fun ping(id: Int): KClass<out IAbstractPacket>? {
        return registry.packetList.get(PacketData(id,state))
    }
}
