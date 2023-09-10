package com.example.hotel.di

import com.example.core.data.HotelRepository
import com.example.core.mappers.HotelMapper
import com.example.hotel.domain.usecases.GetHotelDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class HotelModule {
    @Provides
    fun provideGetHotelDataUseCase(repo: HotelRepository, mapper: HotelMapper): GetHotelDataUseCase = GetHotelDataUseCase(repo, mapper)
}