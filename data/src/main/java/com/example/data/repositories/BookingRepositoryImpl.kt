package com.example.data.repositories

import com.example.core.data.BookingRepository
import com.example.core.entities.booking_info.BookingDataDto
import com.example.core.states.NetworkState
import com.example.data.network.HotelApiService
import javax.inject.Inject

class BookingRepositoryImpl @Inject constructor(
    private val apiService: HotelApiService
) : BookingRepository {
    override suspend fun getBookingData(): NetworkState<BookingDataDto> {
        val result = apiService.getBookingData()

        return if (result.isSuccessful) {
            NetworkState.Success(result.body())
        } else {
            NetworkState.Error(result.code(), result.message())
        }
    }
}