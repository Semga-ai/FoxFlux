import io.netty.channel.ChannelHandlerContext
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

class ClientRepository {
    var data: MutableMap<ChannelHandlerContext, Client> = ConcurrentHashMap<ChannelHandlerContext, Client>()
    fun contain(ctx: ChannelHandlerContext): Boolean {
        return data.containsKey(ctx)
    }
    fun contain(id: UUID): Boolean {
        return data.entries.firstOrNull { it.value.uuid == id } != null
    }
    fun add(ctx: ChannelHandlerContext, client: Client) {
        data.put(ctx, client)
    }
    fun get(ctx: ChannelHandlerContext): Client? {
        return data[ctx]
    }
    fun get(id: UUID): Client? {
        return data.entries.firstOrNull { it.value.uuid == id }?.value
    }
    fun get(client: Client): ChannelHandlerContext? {
        return data.entries.firstOrNull { it.value == client }?.key
    }
}