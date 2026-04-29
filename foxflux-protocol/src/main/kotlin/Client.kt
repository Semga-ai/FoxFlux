import java.util.UUID

data class Client(
    var state: ConnectionStates = ConnectionStates.NONE,
    var registry: PacketRegistry,
    var uuid: UUID? = null
) {
    fun ping(id: Int): IAbstractPacket? {
        return registry.packetList.get(PacketData(id,state))
    }
}
