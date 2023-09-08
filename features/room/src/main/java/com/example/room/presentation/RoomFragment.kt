package com.example.room.presentation

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.navigation.DestinationProvider
import com.example.room.R
import com.example.room.databinding.RoomFragmentBinding
import com.example.core.dao.room.RoomDao
import com.example.core.states.DomainResult
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RoomFragment : Fragment(R.layout.room_fragment) {
    @Inject
    lateinit var destinationProvider: DestinationProvider

    private lateinit var binding: RoomFragmentBinding
    private val viewModel by viewModels<RoomViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RoomFragmentBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchRooms()
        val rooms = mutableListOf<RoomDao>()

        val manager = LinearLayoutManager(requireContext())
        val adapter = RoomsRecyclerViewAdapter(
            rooms = rooms,
            navigateToBook = {
                findNavController().navigate(destinationProvider.provideBookingDestinationId())
            },
            getChip = { getPeculiarityChip(it) }
        )
        binding.roomsRecyclerView.layoutManager = manager
        binding.roomsRecyclerView.adapter = adapter

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        viewModel.rooms.observe(viewLifecycleOwner) {
            when (it) {
                is DomainResult.Success -> {
                    rooms.clear()
                    rooms.addAll(it.data!!)
                    binding.roomsRecyclerView.adapter?.notifyDataSetChanged()
                }
                else -> {}
            }
        }
    }

    private fun getPeculiarityChip(text: String): Chip {
        val chip = Chip(requireContext())

        chip.text = text
        chip.isClickable = false
        chip.typeface = Typeface.create(
            ResourcesCompat.getFont(
                requireContext(),
                com.example.core.R.font.sf_pro_display_regular
            ), Typeface.NORMAL
        )

        chip.setTextColor(Color.parseColor("#828796"))
        chip.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        chip.chipStrokeWidth = 0F
        chip.setBackgroundColor(Color.parseColor("#FBFBFC"))
        return chip
    }
}