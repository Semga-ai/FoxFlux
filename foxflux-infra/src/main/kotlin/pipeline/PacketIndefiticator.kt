package pipeline

import Client
import ClientRepository
import IAbstractPacket
import PacketRegistry
import exception.PipelineException
import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter

class PacketIndefiticator(val clientRepository: ClientRepository, val packetRegistry: PacketRegistry) : ChannelInboundHandlerAdapter() {
    override fun channelRead(ctx: ChannelHandlerContext, msg: Any?) {
        val m = msg as ByteBuf
        if (m.readableBytes() < 1) return
        val id = ProtocolUtils.readVarInt(m)
        if (!clientRepository.contain(ctx)) {
            clientRepository.add(ctx, Client(ConnectionStates.NONE,packetRegistry,null))
        }
        val client: Client = clientRepository.get(ctx) ?: throw PipelineException("Client not found")
        val packet: IAbstractPacket = client.ping(id) ?: throw PipelineException("Registered package $id not found!")
        packet.trigger(client,m)
    }
    override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
        cause.printStackTrace()
        ctx.close()
    }
}