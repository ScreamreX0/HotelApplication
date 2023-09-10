package com.example.core.mappers

import com.example.core.dao.RoomDao
import com.example.core.dto.RoomDto

interface RoomMapper {
    fun mapDtoToDao(roomDto: RoomDto): RoomDao
}