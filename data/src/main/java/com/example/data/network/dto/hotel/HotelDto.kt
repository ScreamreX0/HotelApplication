package com.example.data.network.dto.hotel

data class HotelDto(
    val id: Long?,
    val name: String?,
    val adress: String?,
    val minimal_price: Number?,
    val price_for_it: String?,
    val rating: Number?,
    val rating_name: String?,
    val image_urls: List<String>,
    val about_the_hotel: AboutHotelDto,
)