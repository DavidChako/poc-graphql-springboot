package com.icosahedron.data

interface Fetcher<T> {
    fun fetch(id: String): T
//    fun fetchAll(): List<T>
}