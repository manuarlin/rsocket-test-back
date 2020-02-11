package com.manua.rsockettestback.items

import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Item(val category: String, val price: String, val stocked: Boolean, val name: String)