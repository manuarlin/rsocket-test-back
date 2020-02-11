package com.manua.rsockettestback.items

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.reactive.asFlow
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller

@Controller
class ItemController(private val itemRepository: ItemRepository) {

    @MessageMapping("items")
    fun currentMarketData(categoryFlow: Flow<String>): Flow<Item> = categoryFlow.flatMapMerge { category ->
        itemRepository.findAllByCategory(category)
                .asFlow()
                .onEach { delay(5000) }
    }
}