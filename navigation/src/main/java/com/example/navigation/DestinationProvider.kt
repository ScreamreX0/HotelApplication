package com.example.navigation

import androidx.annotation.IdRes
import androidx.annotation.NavigationRes

interface DestinationProvider {
    @NavigationRes
    fun provideNavigationGraphId(): Int

    @IdRes
    fun provideHotelDestinationId(): Int

    @IdRes
    fun provideRoomDestinationId(): Int

    @IdRes
    fun provideBookingDestinationId(): Int

    @IdRes
    fun providePaidDestinationId(): Int
}