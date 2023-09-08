package com.example.hotelapplication.di

import com.example.core.mappers.BookingDataMapper
import com.example.core.mappers.HotelMapper
import com.example.hotelapplication.mappers.DefaultBookingDataMapper
import com.example.hotelapplication.mappers.DefaultRoomMapper
import com.example.core.mappers.RoomMapper
import com.example.hotelapplication.mappers.DefaultHotelMapper
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MappersModule {
    @Provides
    fun providesHotelMapping(): HotelMapper = DefaultHotelMapper()

    @Provides
    fun providesBookingDataMapper(): BookingDataMapper = DefaultBookingDataMapper()

    @Provides
    fun providesRoomMapper(): RoomMapper = DefaultRoomMapper()
}