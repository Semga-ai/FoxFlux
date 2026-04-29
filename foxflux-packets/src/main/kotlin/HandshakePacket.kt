class HandshakePacket: IAbstractPacket {
    override fun trigger(client: Client, byteBuf: io.netty.buffer.ByteBuf) {
        val protocolVersion = ProtocolUtils.readVarInt(byteBuf)
        val address = ProtocolUtils.readString(byteBuf)
        val port = ProtocolUtils.readUnsignedShort(byteBuf)
        val state = ProtocolUtils.readVarInt(byteBuf)
        System.out.println("$protocolVersion $address $port $state")
        if (state == 1) {
            client.state = ConnectionStates.STATUS
        }
        if (state == 2) {
            client.state = ConnectionStates.PLAY
        }
    }
}