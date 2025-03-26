package com.icosahedron

import com.icosahedron.datomic.schema.Schema
import com.icosahedron.graphql.Book

fun main() {
    val dataClass = Book::class
    val schema = Schema.fromDataClass("book", dataClass)
    println("Schema: $schema")
}
