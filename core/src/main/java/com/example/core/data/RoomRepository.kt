package com.example.core.data

import com.example.core.dto.RoomDto
import com.example.core.states.NetworkState

interface RoomRepository {
    suspend fun getRooms(): NetworkState<List<RoomDto>>
}