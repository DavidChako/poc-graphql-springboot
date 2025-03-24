package com.icosahedron.data.entity

import com.icosahedron.data.Entity
import com.icosahedron.data.Field
import com.icosahedron.data.Schema
import datomic.Util

//class BookEntity : Entity {
//    override fun bootstrapSchema() = Schema.Builder("book")
//        .putField("id", Field(Field.Type.STRING, Field.Cardinality.ONE, "The ID of the book"))
//        .putField("title", Field(Field.Type.STRING, Field.Cardinality.ONE, "The title of the book"))
//        .putField("page-count", Field(Field.Type.LONG, Field.Cardinality.ONE, "The page count of the book"))
//        .putField("author-id", Field(Field.Type.STRING, Field.Cardinality.ONE, "ID of the author of the book"))
//        .build()
//
//    override fun bootstrapData(): List<*> = Util.list(
//        Util.map(
//            ":book/id", "book-1",
//            ":book/title", "Harry Potter and the Philosopher's Stone",
//            ":book/page-count", 223,
//            ":book/author-id", "author-1"
//        ),
//        Util.map(
//            ":book/id", "book-2",
//            ":book/title", "Moby Dick",
//            ":book/page-count", 635,
//            ":book/author-id", "author-2"
//        ),
//        Util.map(
//            ":book/id", "book-3",
//            ":book/title", "Interview with the vampire",
//            ":book/page-count", 371,
//            ":book/author-id", "author-3"
//        )
//    )
//}