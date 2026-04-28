import kotlin.reflect.KClass

class PacketRegistry {
    val packetList: MutableMap<PacketData, KClass<out IAbstractPacket>> = mutableMapOf()

    fun registryPacket(packet: KClass<out IAbstractPacket>, data: PacketData) {
        packetList.put(data,packet)
    }
}