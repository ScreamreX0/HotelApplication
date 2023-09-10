package com.example.core.dao

data class HotelDao(
    val id: Long,
    val name: String,
    val address: String,
    val minimalPrice: Float,
    val priceForIt: String,
    val rating: Int,
    val ratingName: String,
    val images: List<String>,
    val aboutTheHotel: AboutTheHotelDao
)

data class AboutTheHotelDao(
    val description: String,
    val peculiarities: List<String>
)