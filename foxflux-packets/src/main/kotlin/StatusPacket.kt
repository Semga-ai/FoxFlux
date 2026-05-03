import dto.StatusData

class StatusPacket: IAbstractPacket {
    override fun trigger(client: Client, byteBuf: io.netty.buffer.ByteBuf) {
        client.send(0, StatusData("1.21.11", 774, 10, 0, "^0^", false, false))
    }
}