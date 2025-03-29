package com.icosahedron.graphql.old

//import datomic.Connection
//import datomic.Peer
//import kotlin.jvm.javaClass
//import org.slf4j.LoggerFactory
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.context.annotation.PropertySource
//
//@Configuration
//@PropertySource("classpath:application.properties")
//class DatomicConfiguration {
//    @Bean
//    fun connection(@Value("\${datomic.uri}") uri: String): Connection {
//        if (Peer.createDatabase(uri)) {
//            LOG.info("Database created: {}", uri)
//        }
//
//        val connection = Peer.connect(uri)
//        LOG.info("Connection established: {}", connection)
//
//        //BookEntity().bootstrap(connection)
//        addBooks(connection)
//        addAuthors(connection)
//
//        return connection
//    }
//
//    companion object {
//        private val LOG = LoggerFactory.getLogger(DatomicConfiguration::class.java)
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
//}