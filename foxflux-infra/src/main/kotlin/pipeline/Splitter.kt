package pipeline

import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufUtil
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.ByteToMessageDecoder

class Splitter : ByteToMessageDecoder() {
    override fun decode(ctx: ChannelHandlerContext?, inn: ByteBuf, out: MutableList<Any?>) {
        if (!inn.isReadable) return
        inn.markReaderIndex()
        val length = try {
            ProtocolUtils.readVarInt(inn)
        } catch (e: Exception) {
            inn.resetReaderIndex()
            return
        }

        if (inn.readableBytes() < length) {
            inn.resetReaderIndex()
            return
        }

        val packetBuffer = inn.readRetainedSlice(length)
        out.add(packetBuffer)
    }
}