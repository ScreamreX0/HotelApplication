package com.example.hotelapplication.di

import com.example.booking.domain.mappers.BookingDataMapper
import com.example.hotel.domain.mappers.HotelMapper
import com.example.hotelapplication.mappers.DefaultBookingDataMapper
import com.example.hotelapplication.mappers.DefaultRoomMapper
import com.example.room.domain.mappers.RoomMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface MappersModule {
    @Binds
    fun bindHotelMapping(defaultHotelMapper: HotelMapper): HotelMapper

    @Binds
    fun bindBookingDataMapper(defaultBookingDataMapper: DefaultBookingDataMapper): BookingDataMapper

    @Binds
    fun bindRoomMapper(defaultRoomMapper: DefaultRoomMapper): RoomMapper
}