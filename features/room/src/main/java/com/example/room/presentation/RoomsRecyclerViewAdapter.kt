package com.example.room.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.room.databinding.RoomItemBinding
import com.example.core.dao.RoomDao
import com.example.hotel.presentation.CarouselAdapter
import com.google.android.material.chip.Chip

class RoomsRecyclerViewAdapter(
    private val rooms: MutableList<RoomDao>,
    private val navigateToBook: (RoomDao) -> Unit,
    private val getChip: (String) -> Chip,
) : RecyclerView.Adapter<RoomsRecyclerViewAdapter.RoomViewHolder>() {
    inner class RoomViewHolder(val binding: RoomItemBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RoomViewHolder(
        RoomItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        with(holder.binding) {
            chooseRoomButton.setOnClickListener { navigateToBook(rooms[position]) }
            name.text = rooms[position].name
            price.text = "${rooms[position].price.toInt()} ₽"
            rooms[position].peculiarities.forEach {
                chipGroup.addView(getChip(it))
            }
            viewPager.adapter = CarouselAdapter(rooms[position].images)
            pricePer.text = rooms[position].pricePer
        }
    }

    override fun getItemCount() = rooms.size
}