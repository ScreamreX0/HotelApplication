package com.example.hotel.domain.mappers

import com.example.data.network.dto.hotel.HotelDto
import com.example.hotel.domain.dao.HotelDao

interface HotelMapper {
    fun mapDtoToDao(hotelDto: HotelDto): HotelDao
}
