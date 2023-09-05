package com.example.hotelapplication.di

import com.example.hotelapplication.navigation.DefaultDestinationProvider
import com.example.navigation.DestinationProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {
    @Binds
    fun bindDestinationProvider(defaultDestinationProvider: DefaultDestinationProvider): DestinationProvider
}