package com.example.core.dto

data class RoomsListDto(
    val rooms: List<RoomDto>
)

data class RoomDto(
    val id: Long?,
    val name: String?,
    val price: Float?,
    val price_per: String?,
    val peculiarities: List<String>,
    val image_urls: List<String>,
)