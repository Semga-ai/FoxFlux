import io.netty.channel.ChannelHandlerContext

interface IAbstractEncoder {
    fun encode(data: Any, con: ChannelHandlerContext)
}