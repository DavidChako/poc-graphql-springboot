package com.icosahedron.graphql

import clojure.lang.Keyword
import com.icosahedron.data.Field
import com.icosahedron.data.Schema
import datomic.Connection
import datomic.Peer
import datomic.Util
import org.slf4j.LoggerFactory

data class Author(val id: String, val givenName: String, val surname: String) {
    companion object {
        private val LOG = LoggerFactory.getLogger(Author.javaClass)

//        private val authors: List<Author> = listOf(
//            Author("author-1", "Joanne", "Rowling"),
//            Author("author-2", "Herman", "Melville"),
//            Author("author-3", "Anne", "Rice")
//        )
//
//        fun getById(id: String): Author = authors.firstOrNull { it.id == id } ?: Author(id, "", "")

        @JvmStatic
        fun getById(id: String, connection: Connection): Author {
            val query = "[:find (pull ?eid [*]) :where [?eid :author/id \"$id\"]]"
            LOG.info("Executing query:\n{}", query)

            val results = Peer.q(query, connection.db())
            LOG.info("Query results:\n{}", results.joinToString("\n'"))

            if (results.isEmpty()) return Author(id, "", "")
            if (results.size > 1) throw IllegalStateException("Found multiple authors with id $id")

            val author = results.first().first() as Map<*, *>
            val authorId = author[Keyword.intern("author/id")] as String
            assert(authorId == id)

            val givenName = author[Keyword.intern("author/givenName")] as String
            val surname = author[Keyword.intern("author/surname")] as String
            return Author(id, givenName, surname)

//            val query = "[:find ?id, ?givenName, ?surname" +
//                    " :where" +
//                    " [?eid :author/id \"$id\"]" +
//                    " [?eid :author/id ?id]" +
//                    " [?eid :author/givenName ?givenName]" +
//                    " [?eid :author/surname ?surname]" +
//                    "]"
//
//            val results = Peer.q(query, connection.db())
//            LOG.info("Executed query:\n{}", query)
//            LOG.info("Query results:\n{}", results.joinToString("\n'"))
//
//            if (results.isEmpty()) return Author(id, "", "")
//            if (results.size > 1) throw IllegalStateException("Found multiple authors with id $id")
//
//            val author = results.first()
//            assert(author[0] == id)
//
//            val givenName = author[1] as String
//            val surname = author[2] as String
//            return Author(id, givenName, surname)
        }

        @JvmStatic
        fun schema() = Schema.Builder("author")
            .addField("id", Field.Type.STRING, Field.Cardinality.ONE, "The ID of the author")
            .addField("givenName", Field.Type.STRING, Field.Cardinality.ONE, "The given name of the author")
            .addField("surname", Field.Type.STRING, Field.Cardinality.ONE, "The surname of the author")
            .build()

        @JvmStatic
        fun data(): List<*> = Util.list(
            Util.map(
                ":author/id", "author-1",
                ":author/givenName", "Joanne",
                ":author/surname", "Rowling"
            ),
            Util.map(
                ":author/id", "author-2",
                ":author/givenName", "Herman",
                ":author/surname", "Melville"
            ),
            Util.map(
                ":author/id", "author-3",
                ":author/givenName", "Anne",
                ":author/surname", "Rice"
            ),
        )

    }
}