package com.manua.rsockettestback

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.rsocket.server.ServerRSocketFactoryProcessor
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class RSocketTestBackApplication {

    @Bean
    fun processor(): ServerRSocketFactoryProcessor = ServerRSocketFactoryProcessor { factory -> factory.resume() }
}

fun main(args: Array<String>) {
    runApplication<RSocketTestBackApplication>(*args)
}
