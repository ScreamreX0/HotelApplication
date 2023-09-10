package com.example.core.mappers

import com.example.core.dao.HotelDao
import com.example.core.dto.HotelDto

interface HotelMapper {
    fun mapDtoToDao(hotelDto: HotelDto): HotelDao
}
