package com.example.hotelapplication.navigation

import com.example.hotelapplication.R
import com.example.core.navigation.DestinationProvider
import javax.inject.Inject

class DefaultDestinationProvider @Inject constructor() : DestinationProvider {
    override fun provideNavigationGraphId() = R.navigation.nav_main

    override fun provideHotelDestinationId() = R.id.hotel_fragment

    override fun provideRoomDestinationId() = R.id.room_fragment

    override fun provideBookingDestinationId() = R.id.booking_fragment

    override fun providePaidDestinationId() = R.id.paid_fragment
}