import io.netty.buffer.ByteBuf
import usecase.LoginAcknowledgedCase

class LoginAcknowledgedPacket(val case: LoginAcknowledgedCase): IAbstractPacket {
    override fun trigger(client: Client, byteBuf: ByteBuf) {
        case.trg(client)
    }
}