package com.example.paid.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.core.navigation.DestinationProvider
import com.example.paid.R
import com.example.paid.databinding.PaidFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.random.Random

@AndroidEntryPoint
class PaidFragment : Fragment(R.layout.paid_fragment) {
    @Inject
    lateinit var destinationProvider: DestinationProvider

    private lateinit var binding: PaidFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PaidFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initOkayButton()
        initBackButton()
        initScreenDesc()
    }

    private fun initScreenDesc() {
        binding.description.text = getScreenDescription()
    }

    private fun initOkayButton() = binding.okayButton.setOnClickListener {
        findNavController().popBackStack(destinationProvider.provideHotelDestinationId(), false)
    }

    private fun initBackButton() = binding.backButton.setOnClickListener {
        findNavController().navigateUp()
    }

    private fun getScreenDescription() =
        "Подтверждение заказа №${getRandomOrderNumber()} может занять некоторое время (от 1 часа до суток). Как только мы получим ответ от туроператора, вам на почту придет уведомление."

    private fun getRandomOrderNumber() = Random.nextInt(0, Int.MAX_VALUE)
}