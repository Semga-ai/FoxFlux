package org.example

import HandshakePacket
import PacketData
import StatusPacket
import com.google.inject.Guice
import org.example.guice.Modulee

fun main() {
    val injector = Guice.createInjector(Modulee())
    val reg = injector.getInstance(PacketRegistry::class.java)
    reg.registryPacket(HandshakePacket(),PacketData(0,ConnectionStates.NONE))
    reg.registryPacket(StatusPacket(),PacketData(0,ConnectionStates.STATUS))
    injector.getInstance(NettyServer::class.java).start(25565)
    injector.getInstance(TickEngine::class.java).start()
}
