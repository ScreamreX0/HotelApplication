package com.example.hotelapplication.mappers

import com.example.core.Constants
import com.example.core.entities.room.RoomDto
import com.example.core.dao.room.RoomDao
import com.example.core.mappers.RoomMapper
import javax.inject.Inject

class DefaultRoomMapper @Inject constructor() : RoomMapper {
    override fun mapDtoToDao(roomDto: RoomDto) = RoomDao(
        id = roomDto.id ?: -1L,
        name = roomDto.name ?: Constants.ERROR_STRING,
        price = roomDto.price ?: -1F,
        pricePer = roomDto.price_per ?: Constants.ERROR_STRING,
        peculiarities = roomDto.peculiarities,
        images = roomDto.image_urls
    )
}