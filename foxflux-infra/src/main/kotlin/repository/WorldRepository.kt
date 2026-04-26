package repository

import exeption.RepositoryExeption
import model.entity.World

class WorldRepository: IWorldRepository {
    var _worlds: MutableSet<World> = mutableSetOf()
    override fun add(world: World) {
        if (_worlds.contains(world)) {
            throw RepositoryExeption("World already exists")
        }
        _worlds.add(world)
    }

    override fun remove(world: World) {
        if (!_worlds.contains(world)) {
            throw RepositoryExeption("World does not exist")
        }
        _worlds.remove(world)
    }

    override fun contains(world: World): Boolean {
        return _worlds.contains(world)
    }

    override fun get(world: World): World? {
        if (!_worlds.contains(world)) {
            throw RepositoryExeption("World does not exist")
        }
        return _worlds.firstOrNull { it == world }
    }

    override fun saveAll() {
        //Потом
    }

    override fun getAll(world: World): Set<World> {
        return _worlds
    }

    override fun isEmpty(): Boolean {
        return _worlds.isEmpty()
    }

    override fun loadFromDisk() {
        //Потом
    }

}