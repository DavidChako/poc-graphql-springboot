package com.icosahedron.data

import datomic.Connection
import org.slf4j.LoggerFactory

interface Entity<T> {
    fun idQuery(id: String): String
    fun idQueryResultMapper(): T

    fun bootstrapSchema(): Schema
    fun bootstrapData(): List<Any?>

    fun bootstrap(connection: Connection) {
        bootstrap(connection, this)
    }

    companion object {
        private val LOG = LoggerFactory.getLogger(Entity.javaClass)

        fun <T> bootstrap(connection: Connection, entity: Entity<T>) {
            val type = entity.javaClass.simpleName
            val datomicSchema = entity.bootstrapSchema().toDatomic()
            connection.transact(datomicSchema).get()
            LOG.info("{} schema created:\n{}", type, datomicSchema.joinToString("\n"))

            val data = entity.bootstrapData()
            connection.transact(data).get()
            LOG.info("{} data added:\n{}", type, data.joinToString("\n"))
        }
    }
}