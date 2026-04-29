class StatusPacket: IAbstractPacket {
    override fun trigger(client: Client, byteBuf: io.netty.buffer.ByteBuf) {

        client.state = ConnectionStates.NONE
    }
}