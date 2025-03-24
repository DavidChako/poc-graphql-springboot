package com.icosahedron.data

import clojure.lang.Keyword
import kotlin.collections.map
import kotlin.collections.toMutableMap

data class Schema constructor(val entity: String, val fields: Map<String,Field>) {
    fun toDatomic(): List<*> = fields.map { (name, field) -> field.toDatomic(entity, name) }

    fun keyword(name: String) = fields[name]?.keyword ?: ""


    //fun idQuery(id: String) = "[:find (pull ?eid [*]) :where [?eid :book/id \"$id\"]]"

    fun builder() = Builder(entity, fields)

    class Builder(val entity: String, nominalFields: Map<String,Field>) {
        private val fields = nominalFields.toMutableMap()

        constructor(entity: String): this(entity, mapOf())

        fun addField(name: String, type: Field.Type, cardinality: Field.Cardinality, description: String): Builder {
            val keyword = Keyword.intern("$entity/$name")
            val field = Field(keyword, type, cardinality, description)
            fields.put(name, field)
            return this
        }

        fun removeField(name: String): Builder {
            fields.remove(name)
            return this
        }

        fun build() = Schema(entity, fields)
    }
}
