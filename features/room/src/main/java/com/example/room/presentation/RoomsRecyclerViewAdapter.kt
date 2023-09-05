package com.example.room.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.room.databinding.RoomFragmentBinding

class RoomsRecyclerViewAdapter: RecyclerView.Adapter<RoomsRecyclerViewAdapter.RoomViewHolder>() {
    inner class RoomViewHolder(binding: RoomFragmentBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val binding = RoomFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RoomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        // TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return 0
        // TODO("Not yet implemented")
    }
}