package com.icosahedron.graphql.test

import com.icosahedron.data.Field
import com.icosahedron.data.Schema
import com.icosahedron.graphql.Book
import com.icosahedron.graphql.DatomicConfiguration
import datomic.Connection
import datomic.Peer
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import spock.lang.Ignore
import spock.lang.Specification

@Ignore
@ContextConfiguration(classes = DatomicConfiguration)
@TestPropertySource("classpath:application-test.properties")
class LocalSpec extends Specification {
    static LOG = LoggerFactory.getLogger(LocalSpec)

    @Autowired Connection connection

    def "play with schema"() {
        given:
        def initialSchema = new Schema.Builder("book")
                .addField("id", Field.Type.STRING, Field.Cardinality.ONE, "The id of the book")
                .addField("title", Field.Type.STRING, Field.Cardinality.ONE, "The title of the book")
                .addField("pageCount", Field.Type.LONG, Field.Cardinality.ONE, "The page count of the book")
                .addField("authorId", Field.Type.STRING, Field.Cardinality.ONE, "The id of the author of the book")
                .build()

        when:
        def initialDatomicSchema = initialSchema.toDatomic()
        connection.transact(initialDatomicSchema).get()
        then:
        LOG.info('Schema created:\n{}', initialDatomicSchema.join('\n'))

        when:
        def query = "" +
                "[:find (pull ?e [*]), ?type, ?cardinality" +
                " :where\n" +
                " [?e :db/ident ?ident]\n" +
                " [?e :db/valueType ?eType]\n" +
                " [?eType :db/ident ?type]\n" +
                " [?e :db/cardinality ?eCardinality]\n" +
                " [?e :db/cardinality ?eCardinality]\n" +
                " [?eCardinality :db/ident ?cardinality]\n" +
                " [?e :db/doc ?doc]\n" +
                " [_ :db.install/attribute ?e]\n" +
                " [(.toString ?ident) ?val]\n" +
                " [(.startsWith ?val \":book\")]" +
                "]"
        LOG.info("Executing query:\n{}", query)
        then:
        def initialSchemaResults = Peer.q(query, connection.db())
        LOG.info('Initial schema results:\n{}', initialSchemaResults.join('\n'))

        when:
        connection.transact(initialDatomicSchema).get()
        then:
        def reInitialSchemaResults = Peer.q(query, connection.db())
        LOG.info('Re initial schema results:\n{}', reInitialSchemaResults.join('\n'))

        when:
        def revisedSchema = initialSchema.builder()
                .addField("copyright", Field.Type.STRING, Field.Cardinality.ONE, "The copyright of the book")
                .build()
        def revisedDatomicSchema = revisedSchema.toDatomic()
        connection.transact(revisedDatomicSchema).get()
        then:
        def revisedSchemaResults = Peer.q(query, connection.db())
        LOG.info('Revised schema results:\n{}', revisedSchemaResults.join('\n'))
    }

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
