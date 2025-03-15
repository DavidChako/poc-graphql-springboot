package com.icosahedron.graphql.model

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServerApplication

//http://localhost:8080/graphiql?path=/graphql
fun main(args: Array<String>) {
    runApplication<ServerApplication>(*args)
}