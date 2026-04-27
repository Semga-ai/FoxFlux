package protocol

import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufAllocator

class ProtocolUtils {
    fun decode(p: Packet): ByteBuf {
        return ByteBufAllocator.DEFAULT.ioBuffer()
    }

    fun encode(buf: ByteBuf, cl: Client): Packet {
        return Packet("temp")
    }
}