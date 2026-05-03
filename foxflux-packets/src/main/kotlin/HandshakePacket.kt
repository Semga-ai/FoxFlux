class HandshakePacket : IAbstractPacket {
    override fun trigger(client: Client, byteBuf: io.netty.buffer.ByteBuf) {
        val protocolVersion = ProtocolUtils.readVarInt(byteBuf)
        val address = ProtocolUtils.readString(byteBuf)
        val port = ProtocolUtils.readUnsignedShort(byteBuf)
        val state = ProtocolUtils.readVarInt(byteBuf)
        if (state == 1) {
            client.state = ClientStates.STATUS
        }
        if (state == 2) {
            client.state = ClientStates.LOGIN
        }
    }
}