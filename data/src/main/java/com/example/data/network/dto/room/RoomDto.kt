package com.example.data.network.dto.room

data class RoomDto(
    val id: Long?,
    val name: String?,
    val price: Number?,
    val price_per: String?,
    val peculiarities: List<String>,
    val image_urls: List<String>,
)
