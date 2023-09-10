package com.example.data.repositories

import com.example.core.data.RoomRepository
import com.example.core.dto.RoomDto
import com.example.core.states.NetworkState
import com.example.data.network.HotelApiService
import javax.inject.Inject

class RoomRepositoryImpl @Inject constructor(
    private val apiService: HotelApiService
) : RoomRepository {
    override suspend fun getRooms(): NetworkState<List<RoomDto>> {
        val result = apiService.getRooms()

        return if (result.isSuccessful) {
            NetworkState.Success(result.body()?.rooms)
        } else {
            NetworkState.Error(result.code(), result.message())
        }
    }
}