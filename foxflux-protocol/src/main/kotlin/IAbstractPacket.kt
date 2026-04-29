import io.netty.buffer.ByteBuf

interface IAbstractPacket {
    fun trigger(client: Client,byteBuf: ByteBuf)
}