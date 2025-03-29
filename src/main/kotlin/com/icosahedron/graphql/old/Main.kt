package com.icosahedron.graphql.old

import com.icosahedron.datomic.schema.Schema
import com.icosahedron.graphql.data.entity.Book

fun main() {
    val dataClass = Book::class
    val schema = Schema.fromDataClass("book", dataClass)
    println("Schema: $schema")
}
