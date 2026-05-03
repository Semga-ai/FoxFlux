import io.netty.buffer.ByteBuf

class PingPacket: IAbstractPacket {
    override fun trigger(client: Client, byteBuf: ByteBuf) {
        var data = byteBuf.readLong()
        client.send(1,data)
        client.state = ClientStates.NONE
    }

}