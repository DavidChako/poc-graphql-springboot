package com.icosahedron.graphql.data.source

class StaticDataSource<T>(id: (T)->String, list: List<T>) : DataSource<T> {
    private val data = list.associate { id(it) to it }
    override fun getAll() = data
    override fun getById(id: String) = data[id]
}