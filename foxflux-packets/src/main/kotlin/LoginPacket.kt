import io.netty.buffer.ByteBuf
import usecase.LoginCase
import java.util.UUID

class LoginPacket(val case: LoginCase) : IAbstractPacket {
    override fun trigger(client: Client, byteBuf: ByteBuf) {
        val name = ProtocolUtils.readString(byteBuf)
        val uuid = UUID.nameUUIDFromBytes(ByteArray(byteBuf.readableBytes()))
        case.trg(client,name,uuid)
    }
}