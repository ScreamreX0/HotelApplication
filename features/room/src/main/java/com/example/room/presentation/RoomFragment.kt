package com.example.room.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navigation.DestinationProvider
import com.example.room.R
import com.example.room.databinding.RoomFragmentBinding
import com.example.room.domain.dao.RoomDao
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RoomFragment : Fragment(R.layout.room_fragment) {
    @Inject
    lateinit var destinationProvider: DestinationProvider

    private lateinit var binding: RoomFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RoomFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val manager = LinearLayoutManager(requireContext())
        val adapter = RoomsRecyclerViewAdapter(
            listOf(
                RoomDao(
                    id = 1L,
                    name = "Hello world name",
                    price = 10F,
                    peculiarities = listOf("Hello world", "Hello world2"),
                    pricePer = "Hello world price",
                    images = emptyList()
                )
            )
        )
        binding.roomsRecyclerView.layoutManager = manager
        binding.roomsRecyclerView.adapter = adapter

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}