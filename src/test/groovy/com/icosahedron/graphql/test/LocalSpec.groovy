package com.icosahedron.graphql.test

import com.icosahedron.graphql.Book
import com.icosahedron.graphql.DatomicConfiguration
import datomic.Connection
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import spock.lang.Specification

@ContextConfiguration(classes = DatomicConfiguration)
@TestPropertySource("classpath:application-test.properties")
class LocalSpec extends Specification {
    static LOG = LoggerFactory.getLogger(LocalSpec)

    @Autowired Connection connection

    def "create in-memory db, setup schema, add data, query books"() {
        given:
//        def datomicSchema = Book.schema().toDatomic()
//        connection.transact(datomicSchema).get()
//        LOG.info('Schema created:\n{}', datomicSchema.join('\n'))
//
//        def data = Book.data()
//        connection.transact(data).get()
//        LOG.info('Data added:\n{}', data.join('\n'))

//        when:
//        def id = 'book-1'
//        def query = "" +
//                "[:find (pull ?eid [*])" +
//                " :where" +
//                " [?eid :book/id \"$id\"]" +
////                " [?eid :book/id]" +
//                "]"
//        def results = Peer.q(query, connection.db())
//        then:
//        LOG.info("Executed query:\n{}", query)
//        LOG.info('Query results:\n{}', results.join('\n'))

        when:
        def bookId = 'book-1'
        def book = Book.getById(bookId, connection)

        then:
        println(book)
//        def id = 'book-1'
//        def query = "" +
//                "[:find ?book, ?title, ?page, ?author" +
//                " :where" +
//                " [?eid :book/id \"$id\"]" +
//                " [?eid :book/id ?book]" +
//                " [?eid :book/title ?title]" +
//                " [?eid :book/page-count ?page]" +
//                " [?eid :book/author-id ?author]" +
//                "]"

//                "[:find ?title ?pageCount ?authorId\n" +
//                " :where\n" +
//                " [?eid :book/id "book-1"]\n" +
//                " [?eid :book/title ?title]\n" +
//                " [?eid :book/page-count ?pageCount]\n" +
//                " [?eid :book/author-id ?authorId]\n" +
//                "]"
//        def results = Peer.q(query, connection.db())

//        then:
//        LOG.info("Executed query:\n{}", query)
//        LOG.info('Query results:\n{}', results.join('\n'))
    }

    def "create in-memory db, setup schema, add data, query author"() {
        given:
        def datomicSchema = Book.schema().toDatomic()
        connection.transact(datomicSchema).get()
        LOG.info('Schema created:\n{}', datomicSchema.join('\n'))

        def data = Book.data()
        connection.transact(data).get()
        LOG.info('Data added:\n{}', data.join('\n'))

//        when:
//        def query = "" +
//                "[:find (pull ?eid [*])" +
//                " :where" +
//                " [?eid :book/id]" +
//                "]"
//        def results = Peer.q(query, connection.db())
//        then:
//        LOG.info("Executed query:\n{}", query)
//        LOG.info('Query results:\n{}', results.join('\n'))

        when:
        def bookId = 'book-1'
        def book = Book.getById(bookId, connection)

        then:
        println(book)
//        def id = 'book-1'
//        def query = "" +
//                "[:find ?book, ?title, ?page, ?author" +
//                " :where" +
//                " [?eid :book/id \"$id\"]" +
//                " [?eid :book/id ?book]" +
//                " [?eid :book/title ?title]" +
//                " [?eid :book/page-count ?page]" +
//                " [?eid :book/author-id ?author]" +
//                "]"

//                "[:find ?title ?pageCount ?authorId\n" +
//                " :where\n" +
//                " [?eid :book/id "book-1"]\n" +
//                " [?eid :book/title ?title]\n" +
//                " [?eid :book/page-count ?pageCount]\n" +
//                " [?eid :book/author-id ?authorId]\n" +
//                "]"
//        def results = Peer.q(query, connection.db())

//        then:
//        LOG.info("Executed query:\n{}", query)
//        LOG.info('Query results:\n{}', results.join('\n'))
    }
}
