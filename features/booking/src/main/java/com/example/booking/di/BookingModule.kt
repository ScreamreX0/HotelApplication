package com.example.booking.di

import com.example.booking.domain.usecases.GetBookingDataUseCase
import com.example.core.data.BookingRepository
import com.example.core.mappers.BookingDataMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class BookingModule {
    @Provides
    fun provideGetBookingDataUseCase(repo: BookingRepository, mapper: BookingDataMapper): GetBookingDataUseCase = GetBookingDataUseCase(repo, mapper)
}