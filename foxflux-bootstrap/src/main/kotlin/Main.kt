package org.example

import HandshakePacket
import LoginAcknowledgedPacket
import LoginPacket
import PacketData
import PingPacket
import StatusPacket
import com.google.inject.Guice
import encoder.LoginAcknowledgedEncoder
import encoder.LoginEncoder
import encoder.PingEncoder
import encoder.StatusEncoder
import org.example.guice.Modulee
import usecase.LoginAcknowledgedCase
import usecase.LoginCase

fun main() {
    val injector = Guice.createInjector(Modulee())
    val reg = injector.getInstance(PacketRegistry::class.java)
    val loginCase = injector.getInstance(LoginCase::class.java)
    val loginACase = injector.getInstance(LoginAcknowledgedCase::class.java)

    reg.registryPacket(HandshakePacket(),PacketData(0,ClientStates.NONE))
    reg.registryPacket(StatusPacket(),PacketData(0,ClientStates.STATUS))
    reg.registryPacket(PingPacket(),PacketData(1,ClientStates.STATUS))
    reg.registryPacket(LoginPacket(loginCase),PacketData(0,ClientStates.LOGIN))
    reg.registryPacket(LoginAcknowledgedPacket(loginACase),PacketData(3,ClientStates.LOGIN))

    reg.registryEncoder(StatusEncoder(), PacketData(0,ClientStates.STATUS))
    reg.registryEncoder(PingEncoder(), PacketData(1,ClientStates.STATUS))
    reg.registryEncoder(LoginEncoder(), PacketData(2,ClientStates.LOGIN))
    reg.registryEncoder(LoginAcknowledgedEncoder(), PacketData(0,ClientStates.CONFIGURATION))

    injector.getInstance(NettyServer::class.java).start(25565)
    injector.getInstance(TickEngine::class.java).start()
}
