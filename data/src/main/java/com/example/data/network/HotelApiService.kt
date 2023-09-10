package com.example.data.network

import com.example.core.dto.BookingDataDto
import com.example.core.dto.HotelDto
import com.example.core.dto.RoomsListDto
import retrofit2.Response
import retrofit2.http.GET


interface HotelApiService {
    @GET(GET_HOTEL_DATA)
    suspend fun getHotelData(): Response<HotelDto>

    @GET(GET_ROOM_DATA)
    suspend fun getRooms(): Response<RoomsListDto>

    @GET(GET_BOOKING_DATA)
    suspend fun getBookingData(): Response<BookingDataDto>

    companion object {
        const val GET_HOTEL_DATA = "35e0d18e-2521-4f1b-a575-f0fe366f66e3/"
        const val GET_ROOM_DATA = "f9a38183-6f95-43aa-853a-9c83cbb05ecd/"
        const val GET_BOOKING_DATA = "e8868481-743f-4eb2-a0d7-2bc4012275c8/"
    }
}