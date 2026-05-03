package encoder

import IAbstractEncoder
import dto.LoginData
import io.netty.channel.ChannelHandlerContext

class LoginEncoder: IAbstractEncoder {
    override fun encode(data: Any, con: ChannelHandlerContext) {
        if (data !is LoginData) return
        val tempBuf = con.alloc().buffer()
        ProtocolUtils.writeVarInt(tempBuf, 2)
        tempBuf.writeLong(data.uuid.mostSignificantBits)
        tempBuf.writeLong(data.uuid.leastSignificantBits)
        ProtocolUtils.writeString(tempBuf,data.username)
        ProtocolUtils.writeVarInt(tempBuf, data.propertiesCount)
        //tempBuf.writeBoolean(data.StrictErrorHandling)
        val buf = con.alloc().buffer()
        ProtocolUtils.writeVarInt(buf, tempBuf.readableBytes())
        buf.writeBytes(tempBuf)
        con.writeAndFlush(buf)
        tempBuf.release()
    }
}