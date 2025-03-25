package com.icosahedron.data

import com.icosahedron.graphql.Book

fun main() {
    val dataClass = Book::class
    val schema = Schema.fromDataClass(dataClass)
    println("Schema: $schema")
}
