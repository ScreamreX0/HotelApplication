package com.example.hotelapplication.di

import com.example.core.mappers.BookingDataMapper
import com.example.booking.domain.usecases.GetBookingDataUseCase
import com.example.core.data.BookingRepository
import com.example.core.data.HotelRepository
import com.example.core.data.RoomRepository
import com.example.data.repositories.BookingRepositoryImpl
import com.example.data.repositories.HotelRepositoryImpl
import com.example.data.repositories.RoomRepositoryImpl
import com.example.core.mappers.HotelMapper
import com.example.hotel.domain.usecases.GetHotelDataUseCase
import com.example.core.mappers.RoomMapper
import com.example.room.domain.usecases.GetRoomsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun provideGetHotelDataUseCase(repo: HotelRepository, mapper: HotelMapper): GetHotelDataUseCase = GetHotelDataUseCase(repo, mapper)

    @Provides
    fun provideGetBookingDataUseCase(repo: BookingRepository, mapper: BookingDataMapper): GetBookingDataUseCase = GetBookingDataUseCase(repo, mapper)

    @Provides
    fun provideGetRoomsUseCase(repo: RoomRepository, mapper: RoomMapper): GetRoomsUseCase = GetRoomsUseCase(repo, mapper)
}