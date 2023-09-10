package com.example.hotelapplication.mappers

import com.example.core.Constants
import com.example.core.dto.HotelDto
import com.example.core.dao.AboutTheHotelDao
import com.example.core.dao.HotelDao
import com.example.core.mappers.HotelMapper
import javax.inject.Inject

class DefaultHotelMapper @Inject constructor() : HotelMapper {
    override fun mapDtoToDao(hotelDto: HotelDto) = HotelDao(
        id = hotelDto.id ?: -1L,
        name = hotelDto.name ?: Constants.ERROR_STRING,
        address = hotelDto.adress ?: Constants.ERROR_STRING,
        minimalPrice = hotelDto.minimal_price ?: -1F,
        priceForIt = hotelDto.price_for_it ?: Constants.ERROR_STRING,
        rating = hotelDto.rating ?: -1,
        ratingName = hotelDto.rating_name ?: Constants.ERROR_STRING,
        images = hotelDto.image_urls,
        aboutTheHotel = AboutTheHotelDao(
            description = hotelDto.about_the_hotel.description ?: Constants.ERROR_STRING,
            peculiarities = hotelDto.about_the_hotel.peculiarities
        )
    )
}