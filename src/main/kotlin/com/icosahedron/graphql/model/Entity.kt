package com.icosahedron.graphql.model

//@JvmRecord
data class Entity(val id: String) {
    companion object {
        private val entities = mutableMapOf<String, Entity>()

        fun getAll(): Collection<Entity> = entities.values
        fun getById(id: String) = entities.getOrPut(id) { Entity(id) }
    }
}