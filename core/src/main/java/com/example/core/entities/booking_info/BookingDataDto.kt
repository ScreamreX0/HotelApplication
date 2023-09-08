package com.example.core.entities.booking_info

data class BookingDataDto(
    val id: Long?,
    val hotel_name: String?,
    val hotel_adress: String?,
    val horating: Int?,
    val rating_name: String?,
    val departure: String?,
    val arrival_country: String?,
    val tour_date_start: String?,
    val tour_date_stop: String?,
    val number_of_nights: Int?,
    val room: String?,
    val nutrition: String?,
    val tour_price: Float?,
    val fuel_charge: Float?,
    val service_charge: Float?,
)