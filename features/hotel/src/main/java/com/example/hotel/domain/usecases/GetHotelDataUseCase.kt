package com.example.hotel.domain.usecases

import com.example.core.dao.hotel.HotelDao
import com.example.core.data.HotelRepository
import com.example.core.states.DomainResult
import com.example.core.states.ErrorCause
import com.example.core.states.NetworkState
import com.example.core.mappers.HotelMapper
import javax.inject.Inject

class GetHotelDataUseCase @Inject constructor(
    private val hotelRepository: HotelRepository,
    private val hotelMapper: HotelMapper
) {
    suspend fun execute(): DomainResult<HotelDao> = when (val result = hotelRepository.getHotelData()) {
        is NetworkState.Success -> DomainResult.Success(result.data?.let { hotelMapper.mapDtoToDao(it) })
        is NetworkState.Error -> DomainResult.Error(ErrorCause.CONNECTION_LOST, "Упс. Что-то пошло не так")
    }
}