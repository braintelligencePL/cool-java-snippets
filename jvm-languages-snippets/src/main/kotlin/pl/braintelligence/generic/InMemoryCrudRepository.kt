package pl.braintelligence.generic

import java.util.concurrent.ConcurrentHashMap
import kotlin.reflect.KClass


abstract class InMemoryCrudRepository<ENTITY : IdExtractor<ID>, ID> : CustomRepository<ENTITY, ID> {

    private val dataStore = ConcurrentHashMap<ID, ENTITY>()

    override fun save(entity: ENTITY) {
        val entityId = entity.id ?: throw IdExtractorException(entity::class)
        dataStore[entityId] = entity
    }

    override fun contains(id: ID): Boolean = dataStore.containsKey(id)

    override fun findById(id: ID): ENTITY? = dataStore[id]

    override fun findAll(): List<ENTITY> = dataStore.values.toList()

}

interface CustomRepository<ENTITY, ID> {
    fun save(entity: ENTITY)
    fun contains(id: ID): Boolean
    fun findById(id: ID): ENTITY?
    fun findAll(): List<ENTITY>
}

interface IdExtractor<out T> {
    val id: T?
}

internal class IdExtractorException(entity: KClass<*>) : Exception("Entity=$entity has no id.")
