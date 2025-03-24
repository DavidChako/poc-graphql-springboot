package com.icosahedron.data.entity

import com.icosahedron.data.Fetcher
import com.icosahedron.graphql.Book
import datomic.Connection
import datomic.Peer

//class BookFetcher : Fetcher<Book> {
//    override fun getById(id: String, connection: Connection): Book {
//        val query = "[:find ?id, ?title, ?pageCount, ?authorId" +
//                " :where" +
//                " [?eid :book/id \"$id\"]" +
//                " [?eid :book/id ?id]" +
//                " [?eid :book/title ?title]" +
//                " [?eid :book/page-count ?pageCount]" +
//                " [?eid :book/author-id ?authorId]" +
//                "]"
//
//        val results = Peer.q(query, connection.db())
//        LOG.info("Executed query:\n{}", query)
//        LOG.info("Query results:\n{}", results.joinToString("\n'"))
//
//        if (results.isEmpty()) return Book(id, "", 0, "")
//        if (results.size > 1) throw IllegalStateException("Found multiple books with id $id")
//
//        val book = results.first()
//        assert(book[0] == id)
//
//        val title = book[1] as String
//        val pageCount = (book[2] as Int)
//        val authorId = book[3] as String
//        return Book(id, title, pageCount, authorId)
//    }
//}