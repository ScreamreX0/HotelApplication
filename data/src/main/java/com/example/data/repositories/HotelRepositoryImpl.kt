package com.example.data.repositories

import com.example.core.data.HotelRepository
import com.example.core.dto.HotelDto
import com.example.core.states.NetworkState
import com.example.data.network.HotelApiService
import javax.inject.Inject


class HotelRepositoryImpl @Inject constructor(
    private val api: HotelApiService
) : HotelRepository {
    override suspend fun getHotelData(): NetworkState<HotelDto> {
        val result = api.getHotelData()

        return if (result.isSuccessful) {
            NetworkState.Success(result.body())
        } else {
            NetworkState.Error(result.code(), result.message())
        }
    }
}