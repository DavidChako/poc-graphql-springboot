package com.icosahedron.graphql.data.entity

data class Book(val id: String, val title: String, val pageCount: Int, val authorId: String)
//{
//    constructor(data: Map<*,*>): this(
//        data[SCHEMA.keyword("id")] as String,
//        data[SCHEMA.keyword("title")] as String,
//        data[SCHEMA.keyword("pageCount")] as Int,
//        data[SCHEMA.keyword("authorId")] as String
//    )

//    companion object {
//        private val LOG = LoggerFactory.getLogger(Book::class.java)
//
//        @JvmStatic
//        private val SCHEMA = Schema.fromDataClass(Book::class)
//
////        private val SCHEMA = Schema.Builder("book")
////            .addField("id", Field.Type.STRING, Field.Cardinality.ONE, "The id of the book")
////            .addField("title", Field.Type.STRING, Field.Cardinality.ONE, "The title of the book")
////            .addField("pageCount", Field.Type.LONG, Field.Cardinality.ONE, "The page count of the book")
////            .addField("authorId", Field.Type.STRING, Field.Cardinality.ONE, "The id of the author of the book")
////            .build()
//
//        @JvmStatic
//        private val SAMPLE_DATA: List<*> = Util.list(
//            Util.map(
//                ":book/id", "book-1",
//                ":book/title", "Harry Potter and the Philosopher's Stone",
//                ":book/pageCount", 223,
//                ":book/authorId", "author-1"
//            ),
//            Util.map(
//                ":book/id", "book-2",
//                ":book/title", "Moby Dick",
//                ":book/pageCount", 635,
//                ":book/authorId", "author-2"
//            ),
//            Util.map(
//                ":book/id", "book-3",
//                ":book/title", "Interview with the vampire",
//                ":book/pageCount", 371,
//                ":book/authorId", "author-3"
//            )
//        )

//        private val titleKeyword = Keyword.intern("book/title")
//        private val pageCountKeyword = Keyword.intern("book/pageCount")
//        private val authorIdKeyword = Keyword.intern("book/authorId")

//        private val books: List<Book> = listOf(
//            Book("book-1", "Harry Potter and the Philosopher's Stone", 223, "author-1"),
//            Book("book-2", "Moby Dick", 635, "author-2"),
//            Book("book-3", "Interview with the vampire", 371, "author-3")
//        )
//
//        @JvmStatic
//        fun getById(id: String): Book = books.firstOrNull { it.id == id } ?: Book(id, "", 0, "")

//        @JvmStatic
//        fun getById(id: String, connection: Connection): Book {
//            val query = "[:find (pull ?eid [*]) :where [?eid :book/id \"$id\"]]"
//            LOG.info("Executing query:\n{}", query)
//
//            val results = Peer.q(query, connection.db())
//            LOG.info("Query results:\n{}", results.joinToString("\n'"))
//
//            if (results.isEmpty()) return Book(id, "", 0, "")
//            if (results.size > 1) throw IllegalStateException("Found multiple books with id $id")
//
//            return Book(results.first().first() as Map<*, *>)
//        }
//
//        @JvmStatic
//        fun schema() = SCHEMA
//
//        @JvmStatic
//        fun data() = SAMPLE_DATA
//    }
//}