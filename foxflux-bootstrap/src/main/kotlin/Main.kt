package org.example

import com.google.inject.Guice
import org.example.guice.Modulee

fun main() {
    val injector = Guice.createInjector(Modulee())
    injector.getInstance(NettyServer::class.java).start(25565)
    injector.getInstance(TickEngine::class.java).start()
}
