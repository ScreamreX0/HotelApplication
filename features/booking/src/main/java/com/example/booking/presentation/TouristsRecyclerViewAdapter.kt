package com.example.booking.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.booking.R
import com.example.booking.databinding.TouristItemBinding
import com.example.core.dao.TouristDao

class TouristsRecyclerViewAdapter(
    private val tourists: MutableList<TouristDao>
) :
    RecyclerView.Adapter<TouristsRecyclerViewAdapter.TouristsViewHolder>() {
    inner class TouristsViewHolder(val binding: TouristItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TouristsViewHolder(
        TouristItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: TouristsViewHolder, position: Int) {
        with(holder.binding) {
            titleTourist.text = tourists[position].getTitle()

            // Name
            nameEditText.setOnFocusChangeListener { _, hasFocus ->
                if (!hasFocus) tourists[position].name = (nameEditText.text ?: "").toString()
            }

            // Expand
            expand.setOnClickListener {
                if (dropdownContainer.visibility == View.GONE) {
                    dropdownContainer.visibility = View.VISIBLE
                    arrow.setImageResource(R.drawable.arrow_up_blue)
                } else {
                    dropdownContainer.visibility = View.GONE
                    arrow.setImageResource(com.example.core.R.drawable.arrow_down_blue)
                }
            }
        }
    }

    override fun getItemCount() = tourists.size
}