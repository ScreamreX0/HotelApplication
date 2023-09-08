package com.example.booking.domain.usecases

import com.example.core.mappers.BookingDataMapper
import com.example.core.dao.booking.BookingDataDao
import com.example.core.data.BookingRepository
import com.example.core.states.DomainResult
import com.example.core.states.ErrorCause
import com.example.core.states.NetworkState
import javax.inject.Inject

class GetBookingDataUseCase @Inject constructor(
    private val bookingRepository: BookingRepository,
    private val bookingDataMapper: BookingDataMapper,
) {
    suspend fun execute(): DomainResult<BookingDataDao> = when (val result = bookingRepository.getBookingData()) {
        is NetworkState.Success -> DomainResult.Success(result.data?.let { bookingDataMapper.mapDtoToDao(it) })
        is NetworkState.Error -> DomainResult.Error(ErrorCause.CONNECTION_LOST, "Упс. Что-то пошло не так")
    }
}