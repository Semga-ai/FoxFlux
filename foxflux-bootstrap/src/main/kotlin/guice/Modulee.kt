package org.example.guice

import com.google.inject.AbstractModule
import com.google.inject.Scopes
import repository.IWorldRepository
import repository.WorldRepository

class Modulee : AbstractModule() {
    override fun configure() {
        bind(IWorldRepository::class.java).to(WorldRepository::class.java).`in`(Scopes.SINGLETON)
        bind(NettyServer::class.java).`in`(Scopes.SINGLETON)
        bind(TickEngine::class.java).asEagerSingleton()
    }
}