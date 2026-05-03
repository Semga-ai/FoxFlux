package encoder

import IAbstractEncoder
import io.netty.channel.ChannelHandlerContext

class PingEncoder: IAbstractEncoder {
    override fun encode(data: Any, con: ChannelHandlerContext) {
        if (data !is Long) return
        val tempBuf = con.alloc().buffer()
        ProtocolUtils.writeVarInt(tempBuf,1)
        tempBuf.writeLong(data)
        val buf = con.alloc().buffer()
        ProtocolUtils.writeVarInt(buf, tempBuf.readableBytes())
        buf.writeBytes(tempBuf)
        con.writeAndFlush(buf)
        tempBuf.release()
    }
}