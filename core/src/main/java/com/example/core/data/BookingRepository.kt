package com.example.core.data

import com.example.core.dto.BookingDataDto
import com.example.core.states.NetworkState

interface BookingRepository {
    suspend fun getBookingData(): NetworkState<BookingDataDto>
}