package com.icosahedron.graphql

import com.icosahedron.graphql.data.entity.Author
import com.icosahedron.graphql.data.entity.Book
import com.icosahedron.graphql.data.source.DataSource
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class EntityController {
    @Autowired
    var bookDataSource: DataSource<Book>? = null

    @Autowired
    var authorDataSource: DataSource<Author>? = null

//    @QueryMapping
//    fun bookById(@Argument id: String) = bookDataSource?.getById(id)
//    fun bookById(@Argument id: String) = Book.getById(id)
//    fun bookById(@Argument id: String) = Book.getById(id, connection!!)

//    @SchemaMapping
//    fun author(book: Book) = authorDataSource?.getById(book.authorId)
//    fun author(book: Book) = Author.getById(book.authorId, connection!!)

    @QueryMapping
    fun bookById(@Argument id: String): Book? {
        LOG.info("Query book by id: $id")

        if (bookDataSource == null) {
            throw IllegalStateException("bookDataSource is null")
        }

        val book = bookDataSource!!.getById(id)
        LOG.info("Found book: {}", book)
        return book

        //return bookDataSource!!.getById(id)
    }// = bookDataSource?.getById(id)

    @SchemaMapping
    fun author(book: Book) = authorDataSource?.getById(book.authorId)

    companion object {
        private val LOG = LoggerFactory.getLogger(EntityController::class.java)
    }
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