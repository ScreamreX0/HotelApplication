package com.example.hotelapplication.mappers

import com.example.core.Constants
import com.example.data.network.dto.room.RoomDto
import com.example.room.domain.dao.RoomDao
import com.example.room.domain.mappers.RoomMapper
import javax.inject.Inject

class DefaultRoomMapper @Inject constructor() : RoomMapper {
    override fun mapDtoToDao(roomDto: RoomDto) = RoomDao(
        id = (roomDto.id ?: -1F) as Long,
        name = roomDto.name ?: Constants.ERROR_STRING,
        price = (roomDto.price ?: -1) as Float,
        pricePer = roomDto.price_per ?: Constants.ERROR_STRING,
        peculiarities = roomDto.peculiarities,
        images = roomDto.image_urls
    )
}