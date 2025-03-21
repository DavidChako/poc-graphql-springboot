package com.icosahedron.graphql.model

import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class EntityController {
    @QueryMapping
    fun entityById(@Argument id: String) = Entity.getById(id)
}

/*
query query {
    entityById(id: "entity-2") {
        id
    }
}
*/