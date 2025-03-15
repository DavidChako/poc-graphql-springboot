package com.icosahedron.graphql.model

@JvmRecord
data class Author(val id: String, val firstName: String, val lastName: String) {
    companion object {
        private val authors: List<Author> = listOf(
            Author("author-1", "Joanne", "Rowling"),
            Author("author-2", "Herman", "Melville"),
            Author("author-3", "Anne", "Rice")
        )

        fun getById(id: String): Author = authors.firstOrNull { it.id == id } ?: Author(id, "", "")
    }
}