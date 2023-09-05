package com.example.room.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.room.databinding.RoomItemBinding
import com.example.room.domain.dao.RoomDao

class RoomsRecyclerViewAdapter(
    private val rooms: List<RoomDao>,
    private val navigateToBook: (RoomDao) -> Unit
): RecyclerView.Adapter<RoomsRecyclerViewAdapter.RoomViewHolder>() {
    inner class RoomViewHolder(val binding: RoomItemBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val binding = RoomItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RoomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        holder.binding.chooseRoomButton.setOnClickListener { navigateToBook(rooms[position]) }
    }

    override fun getItemCount() = rooms.size
}