package com.manua.rsockettestback.items

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux

interface ItemRepository : ReactiveMongoRepository<Item, Long> {
    fun findAllByCategory(category: String): Flux<Item>
}