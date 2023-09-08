package com.example.hotelapplication.di

import com.example.core.navigation.DestinationProvider
import com.example.hotelapplication.navigation.DefaultDestinationProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class NavigationModule {
    @Provides
    fun providesDestinationProvider(): DestinationProvider = DefaultDestinationProvider()
}