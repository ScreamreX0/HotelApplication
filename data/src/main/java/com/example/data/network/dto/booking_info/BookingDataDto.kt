package com.example.data.network.dto.booking_info

data class BookingDataDto(
    val id: Long?,
    val hotel_name: String?,
    val hotel_adress: String?,
    val horating: Number?,
    val rating_name: String?,
    val departure: String?,
    val arrival_country: String?,
    val tour_date_start: String?,
    val tour_date_stop: String?,
    val number_of_nights: Number?,
    val room: String?,
    val nutrition: String?,
    val tour_price: Number?,
    val fuel_charge: Number?,
    val service_charge: Number?,
)