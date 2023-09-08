package com.example.core.mappers

import com.example.core.dao.room.RoomDao
import com.example.core.entities.room.RoomDto

interface RoomMapper {
    fun mapDtoToDao(roomDto: RoomDto): RoomDao
}