package encoder

import IAbstractEncoder
import dto.StatusData
import io.netty.channel.ChannelHandlerContext

class StatusEncoder : IAbstractEncoder {
    override fun encode(data: Any, con: ChannelHandlerContext) {
        if (data !is StatusData) return
        val txt = """
            {
                "version": {
                    "name": "${data.versionName}",
                    "protocol": ${data.protocol}
                },
                "players": {
                    "max": ${data.maxPlayers}, 
                    "online": ${data.onlinePlayers}, 
                    "sample": []
                },
                "description": {
                    "text": "${data.description}"
                },
                "favicon": "",
                "enforcesSecureChat": ${data.enforcesSecureChat},
                "previewsChat": ${data.previewsChat}
            }
            """.trimIndent().replace("\n", "")
        val tempBuf = con.alloc().buffer()
        ProtocolUtils.writeVarInt(tempBuf,0)
        ProtocolUtils.writeString(tempBuf, txt)
        val finalBuf = con.alloc().buffer()
        ProtocolUtils.writeVarInt(finalBuf, tempBuf.readableBytes())
        finalBuf.writeBytes(tempBuf)
        con.writeAndFlush(finalBuf)
        tempBuf.release()
    }
}