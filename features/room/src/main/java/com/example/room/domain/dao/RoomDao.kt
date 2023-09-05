package com.example.room.domain.dao

data class RoomDao(
    val id: Long,
    val name: String,
    val price: Float,
    val pricePer: String,
    val peculiarities: List<String>,
    val images: List<String>
)