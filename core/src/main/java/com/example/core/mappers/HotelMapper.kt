package com.example.core.mappers

import com.example.core.dao.hotel.HotelDao
import com.example.core.entities.hotel.HotelDto

interface HotelMapper {
    fun mapDtoToDao(hotelDto: HotelDto): HotelDao
}
