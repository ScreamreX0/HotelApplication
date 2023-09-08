package com.example.core.mappers

import com.example.core.dao.booking.BookingDataDao
import com.example.core.entities.booking_info.BookingDataDto

interface BookingDataMapper {
    fun mapDtoToDao(bookingDataDto: BookingDataDto): BookingDataDao?
}