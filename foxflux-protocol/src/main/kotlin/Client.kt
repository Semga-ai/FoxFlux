import IAbstractPacket
import java.util.UUID

data class Client(
    var state: ClientStates = ClientStates.NONE,
    var registry: PacketRegistry,
    var uuid: UUID? = null,
    var clientRepository: ClientRepository
) : IAbstractClient {
    override fun ping(id: Int): IAbstractPacket? {
        return registry.packetList.get(PacketData(id,state))
    }

    override fun send(id: Int, data: Any) {
        val enc = registry.encoderList.get(PacketData(id,state))
        if (enc != null) {
            val ctx = clientRepository.get(this)
            if (ctx != null) {
                enc.encode(data,ctx)
            }
        }
    }

    override fun changeState(newState: ClientStates) {
        this.state = newState
    }
}
