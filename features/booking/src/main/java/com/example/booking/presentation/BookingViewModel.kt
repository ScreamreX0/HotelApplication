package com.example.booking.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booking.domain.usecases.GetBookingDataUseCase
import com.example.core.dao.BookingDataDao
import com.example.core.states.DomainResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookingViewModel @Inject constructor(
    private val getBookingDataUseCase: GetBookingDataUseCase
) : ViewModel() {
    val bookingData = MutableLiveData<DomainResult<BookingDataDao>>()

    fun fetchBookingData() = viewModelScope.launch {
        bookingData.value = DomainResult.Loading
        bookingData.value = getBookingDataUseCase.execute()
    }
}