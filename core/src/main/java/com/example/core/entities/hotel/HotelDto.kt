package com.example.core.entities.hotel

data class HotelDto(
    val id: Long?,
    val name: String?,
    val adress: String?,
    val minimal_price: Float?,
    val price_for_it: String?,
    val rating: Int?,
    val rating_name: String?,
    val image_urls: List<String>,
    val about_the_hotel: AboutHotelDto,
)