package com.example.hotel.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.dao.hotel.HotelDao
import com.example.core.states.DomainResult
import com.example.core.states.NetworkState
import com.example.hotel.domain.usecases.GetHotelDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotelViewModel @Inject constructor(
    private val getHotelDataUseCase: GetHotelDataUseCase,
) : ViewModel() {
    val hotelData: MutableLiveData<DomainResult<HotelDao>> = MutableLiveData<DomainResult<HotelDao>>()

    fun fetchHotelData() = viewModelScope.launch {
        hotelData.value = DomainResult.Loading
        hotelData.value = getHotelDataUseCase.execute()
    }
}
