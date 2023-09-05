package com.example.room.domain.mappers

import com.example.data.network.dto.room.RoomDto
import com.example.room.domain.dao.RoomDao

interface RoomMapper {
    fun mapDtoToDao(roomDto: RoomDto): RoomDao
}