package com.example.room.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.dao.room.RoomDao
import com.example.core.states.DomainResult
import com.example.room.domain.usecases.GetRoomsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(
    private val getRoomsUseCase: GetRoomsUseCase
) : ViewModel() {
    val rooms: MutableLiveData<DomainResult<List<RoomDao>>> = MutableLiveData()

    fun fetchRooms() = viewModelScope.launch {
        rooms.value = DomainResult.Loading
        rooms.value = getRoomsUseCase.execute()
    }
}