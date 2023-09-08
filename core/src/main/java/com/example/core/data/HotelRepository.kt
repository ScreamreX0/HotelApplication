package com.example.core.data

import com.example.core.entities.hotel.HotelDto
import com.example.core.states.NetworkState

interface HotelRepository {
    suspend fun getHotelData(): NetworkState<HotelDto>
}