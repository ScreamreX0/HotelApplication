package com.example.hotel.presentation

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.fonts.Font
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.core.extentions.log
import com.example.core.navigation.DestinationProvider
import com.example.core.states.DomainResult
import com.example.hotel.R
import com.example.hotel.databinding.HotelFragmentBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HotelFragment : Fragment(R.layout.hotel_fragment) {

    @Inject
    lateinit var destinationProvider: DestinationProvider
    private lateinit var binding: HotelFragmentBinding
    private val viewModel by viewModels<HotelViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HotelFragmentBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchHotelData()

        binding.chooseRoomButton.setOnClickListener {
            findNavController().navigate(destinationProvider.provideRoomDestinationId())
        }

        viewModel.hotelData.observe(viewLifecycleOwner) {
            when (it) {
                is DomainResult.Success -> {
                    val data = it.data!!

                    binding.name.text = data.name
                    binding.address.text = data.address
                    binding.minimalPrice.text = "от ${data.minimalPrice.toInt()} ₽"
                    binding.priceForIt.text = data.priceForIt
                    binding.rating.text = "${data.rating} ${data.ratingName}"
                    binding.description.text = data.aboutTheHotel.description
                    data.aboutTheHotel.peculiarities.forEach { peculitarity ->
                        binding.peculiaritiesChipGroup.addView(getPeculiarityChip(peculitarity))
                    }
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