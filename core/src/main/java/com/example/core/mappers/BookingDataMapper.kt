package com.example.core.mappers

import com.example.core.dao.BookingDataDao
import com.example.core.dto.BookingDataDto

interface BookingDataMapper {
    fun mapDtoToDao(bookingDataDto: BookingDataDto): BookingDataDao?
}