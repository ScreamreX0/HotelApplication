package com.example.hotel.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.hotel.R
import com.example.hotel.databinding.HotelFragmentBinding
import com.example.navigation.DestinationProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HotelFragment : Fragment(R.layout.hotel_fragment) {

    @Inject
    lateinit var destinationProvider: DestinationProvider

    private lateinit var binding: HotelFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HotelFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.chooseRoomButton.setOnClickListener {
            findNavController().navigate(destinationProvider.provideRoomDestinationId())
        }
    }
}