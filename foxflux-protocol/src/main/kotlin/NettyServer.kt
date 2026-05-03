import com.google.inject.Inject
import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import pipeline.PacketIndefiticator
import pipeline.Splitter

class NettyServer @Inject constructor(val packetRegistry: PacketRegistry,val clientRepository: ClientRepository) {
    fun start(port: Int) {
        var connecter = NioEventLoopGroup(1)
        var worker = NioEventLoopGroup()

        try {
            var server = ServerBootstrap()
            server.group(connecter, worker)
                .channel(NioServerSocketChannel::class.java)
                .childHandler(object : ChannelInitializer<SocketChannel>() {
                    @Throws(Exception::class)
                    public override fun initChannel(ch: SocketChannel) {
                        ch.pipeline().addLast(Splitter(), PacketIndefiticator(clientRepository,packetRegistry))
                    }
                })
                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
            val channel: ChannelFuture = server.bind(port).sync()
            channel.channel().closeFuture().sync()
        } finally {
            connecter.shutdownGracefully()
            worker.shutdownGracefully()
        }
    }
}