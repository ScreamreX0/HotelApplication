package com.example.core.dao

data class BookingDataDao(
    val id: Long,
    val hotelName: String,
    val hotelAddress: String,
    val rating: Int,
    val ratingName: String,
    val departure: String,
    val arrivalCountry: String,
    val tourDateStart: String,
    val tourDateStop: String,
    val numberOfNights: Int,
    val room: String,
    val nutrition: String,
    val tourPrice: Float,
    val fuelCharge: Float,
    val serviceCharge: Float
)