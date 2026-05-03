import java.util.concurrent.ConcurrentHashMap

class PacketRegistry {
    val packetList: MutableMap<PacketData, IAbstractPacket> = ConcurrentHashMap()
    val encoderList : MutableMap<PacketData,IAbstractEncoder> = ConcurrentHashMap()
    fun registryPacket(packet: IAbstractPacket, data: PacketData) {
        packetList.put(data,packet)
    }

    fun registryEncoder(encoder: IAbstractEncoder, data: PacketData) {
        encoderList.put(data,encoder)
    }
}