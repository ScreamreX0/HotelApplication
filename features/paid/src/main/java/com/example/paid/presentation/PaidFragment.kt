package com.example.paid.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigation.DestinationProvider
import com.example.paid.R
import com.example.paid.databinding.PaidFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.NonDisposableHandle.parent
import javax.inject.Inject

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

        val navigateToStart = {
            findNavController().popBackStack(destinationProvider.provideHotelDestinationId(), false)
        }

        binding.okayButton.setOnClickListener { navigateToStart() }

        binding.backButton.setOnClickListener { navigateToStart() }
    }
}