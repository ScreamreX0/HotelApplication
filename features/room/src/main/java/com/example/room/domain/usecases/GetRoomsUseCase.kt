package com.example.room.domain.usecases

import com.example.core.dao.RoomDao
import com.example.core.data.RoomRepository
import com.example.core.states.DomainResult
import com.example.core.states.ErrorCause
import com.example.core.states.NetworkState
import com.example.core.mappers.RoomMapper
import javax.inject.Inject

class GetRoomsUseCase @Inject constructor(
    private val roomRepository: RoomRepository,
    private val roomMapper: RoomMapper,
) {
    suspend fun execute(): DomainResult<List<RoomDao>> =
        when (val result = roomRepository.getRooms()) {
            is NetworkState.Success -> DomainResult.Success(result.data?.let { rooms ->
                rooms.map { roomMapper.mapDtoToDao(it) }
            })

            is NetworkState.Error -> DomainResult.Error(
                ErrorCause.CONNECTION_LOST,
                "Упс. Что-то пошло не так"
            )
        }
}