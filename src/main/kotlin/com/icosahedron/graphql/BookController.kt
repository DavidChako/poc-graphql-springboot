package com.icosahedron.graphql

import datomic.Connection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class BookController {
    @Autowired
    var connection: Connection? = null

    @QueryMapping
//    fun bookById(@Argument id: String) = Book.getById(id)
    fun bookById(@Argument id: String) = Book.getById(id, connection!!)

    @SchemaMapping
    fun author(book: Book) = Author.getById(book.authorId, connection!!)
}

/*
query query {
    bookById(id: "book-2") {
        id
        title
        pageCount
        author {
            id
            givenName
            surname
        }
    }
}
*/