package repository

import model.entity.World

interface IWorldRepository {
    fun add(world: World)
    fun remove(world: World)
    fun contains(world: World): Boolean
    fun get(world: World): World?
    fun saveAll()
    fun getAll(world: World): Set<World>
    fun isEmpty(): Boolean
    fun loadFromDisk()
}