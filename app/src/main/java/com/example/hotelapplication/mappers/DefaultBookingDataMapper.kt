package com.example.hotelapplication.mappers

import com.example.booking.domain.dao.BookingDataDao
import com.example.booking.domain.mappers.BookingDataMapper
import com.example.core.Constants
import com.example.data.network.dto.booking_info.BookingDataDto
import javax.inject.Inject

class DefaultBookingDataMapper @Inject constructor() : BookingDataMapper {
    override fun mapDtoToDao(bookingDataDto: BookingDataDto) = BookingDataDao(
        id = bookingDataDto.id ?: -1L,
        hotelName = bookingDataDto.hotel_name ?: Constants.ERROR_STRING,
        hotelAddress = bookingDataDto.hotel_adress ?: Constants.ERROR_STRING,
        rating = (bookingDataDto.horating ?: -1) as Int,
        ratingName = bookingDataDto.rating_name ?: Constants.ERROR_STRING,
        departure = bookingDataDto.departure ?: Constants.ERROR_STRING,
        arrivalCountry = bookingDataDto.arrival_country ?: Constants.ERROR_STRING,
        tourDateStart = bookingDataDto.tour_date_start ?: Constants.ERROR_STRING,
        tourDateStop = bookingDataDto.tour_date_stop ?: Constants.ERROR_STRING,
        numberOfNights = (bookingDataDto.number_of_nights ?: -1) as Int,
        room = bookingDataDto.room ?: Constants.ERROR_STRING,
        nutrition = bookingDataDto.nutrition ?: Constants.ERROR_STRING,
        tourPrice = (bookingDataDto.tour_price ?: -1F) as Float,
        fuelCharge = (bookingDataDto.fuel_charge ?: -1F) as Float,
        serviceCharge = (bookingDataDto.service_charge ?: -1F) as Float
    )
}