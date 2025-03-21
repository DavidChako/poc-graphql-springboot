package com.icosahedron.graphql.model

import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class BookController {
    @QueryMapping
    fun bookById(@Argument id: String) = Book.getById(id)

    @SchemaMapping
    fun author(book: Book) = Author.getById(book.authorId)
}

/*
query query {
    bookById(id: "book-2") {
        id
        name
        pageCount
        author {
            firstName
            lastName
        }
    }
}
*/