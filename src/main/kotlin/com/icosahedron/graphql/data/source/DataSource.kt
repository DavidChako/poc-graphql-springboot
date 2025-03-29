package com.icosahedron.graphql.data.source

interface DataSource<T> {
    fun getAll(): Map<String, T>
    fun getById(id: String): T?
}