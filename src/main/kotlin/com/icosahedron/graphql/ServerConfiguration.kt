package com.icosahedron.graphql

import com.icosahedron.graphql.data.entity.Author
import com.icosahedron.graphql.data.entity.Book
import com.icosahedron.graphql.data.source.StaticDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@PropertySource("classpath:application.properties")
class ServerConfiguration {
    @Bean
    fun bookDataSource() = StaticDataSource<Book>(
        Book::id,
        listOf(
            Book("book-1", "Harry Potter and the Philosopher's Stone", 223, "author-1"),
            Book("book-2", "Moby Dick", 635, "author-2"),
            Book("book-3", "Interview with the vampire", 371, "author-3")
        )
    )

    @Bean
    fun authorDataSource() = StaticDataSource<Author>(
        Author::id,
        listOf(
            Author("author-1", "Joanne", "Rowling"),
            Author("author-2", "Herman", "Melville"),
            Author("author-3", "Anne", "Rice")
        )
    )

//    companion object {
//        private val LOG = LoggerFactory.getLogger(ServerConfiguration::class.java)
//
//        private fun addBooks(connection: Connection) {
//            val datomicSchema = Book.schema().toDatomic()
//            connection.transact(datomicSchema).get()
//            LOG.info("Book schema created:\n{}", datomicSchema.joinToString("\n"))
//
//            val data = Book.data()
//            connection.transact(data).get()
//            LOG.info("Book data added:\n{}", data.joinToString("\n"))
//        }
//
//        private fun addAuthors(connection: Connection) {
//            val datomicSchema = Author.schema().toDatomic()
//            connection.transact(datomicSchema).get()
//            LOG.info("Author schema created:\n{}", datomicSchema.joinToString("\n"))
//
//            val data = Author.data()
//            connection.transact(data).get()
//            LOG.info("Author data added:\n{}", data.joinToString("\n"))
//        }
//    }
}