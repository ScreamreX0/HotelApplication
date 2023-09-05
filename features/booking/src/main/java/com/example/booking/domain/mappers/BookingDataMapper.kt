package com.example.booking.domain.mappers

import com.example.booking.domain.dao.BookingDataDao
import com.example.data.network.dto.booking_info.BookingDataDto

interface BookingDataMapper {
    fun mapDtoToDao(bookingDataDto: BookingDataDto): BookingDataDao
}