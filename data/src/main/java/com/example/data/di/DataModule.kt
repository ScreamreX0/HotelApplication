package com.example.data.di

import com.example.core.data.BookingRepository
import com.example.core.data.HotelRepository
import com.example.core.data.RoomRepository
import com.example.data.network.HotelApiService
import com.example.data.repositories.BookingRepositoryImpl
import com.example.data.repositories.HotelRepositoryImpl
import com.example.data.repositories.RoomRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun providesHotelRepository(api: HotelApiService): HotelRepository = HotelRepositoryImpl(api)

    @Provides
    @Singleton
    fun providesRoomRepository(api: HotelApiService): RoomRepository = RoomRepositoryImpl(api)

    @Provides
    @Singleton
    fun providesBookingRepository(api: HotelApiService): BookingRepository = BookingRepositoryImpl(api)
}