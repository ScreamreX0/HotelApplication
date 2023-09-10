package com.example.room.di

import com.example.core.data.RoomRepository
import com.example.core.mappers.RoomMapper
import com.example.room.domain.usecases.GetRoomsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {
    @Provides
    fun provideGetRoomsUseCase(repo: RoomRepository, mapper: RoomMapper): GetRoomsUseCase = GetRoomsUseCase(repo, mapper)
}