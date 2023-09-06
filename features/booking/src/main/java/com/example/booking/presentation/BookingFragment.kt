package com.example.booking.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.booking.R
import com.example.booking.databinding.BookingFragmentBinding
import com.example.navigation.DestinationProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BookingFragment : Fragment(R.layout.booking_fragment) {
    @Inject
    lateinit var destinationProvider: DestinationProvider

    private lateinit var binding: BookingFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BookingFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.payButton.setOnClickListener {
            // TODO("Добавить проверку на обязательное заполнение всех полей")
            findNavController().navigate(destinationProvider.providePaidDestinationId())
        }
        binding.backButton.setOnClickListener { findNavController().navigateUp() }
        binding.phoneNumberEditText.maskPhoneNumber()
        binding.mailEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val text = binding.mailEditText.text ?: ""
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(text).matches()) {
                    binding.mailLayout.error = "Неверный формат"
                } else {
                    binding.mailLayout.error = null
                }
            }
        }
    }
}

fun EditText.maskPhoneNumber() {
    val countryCode = 7
    addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        @SuppressLint("SetTextI18n")
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            removeTextChangedListener(this)

            val text = (p0?.toString() ?: "")
                .filter { it.isDigit() }
                .removePrefix("$countryCode")
            var formattedText = ""
            var digitIndex = 0
            " (***) ***-**-**".toCharArray().forEach { char ->
                if (char == '*' && digitIndex < text.length) {
                    formattedText += text[digitIndex]
                    digitIndex++
                } else {
                    formattedText += char
                }
            }

            val result = "+$countryCode$formattedText"

            setText(result)

            result.forEachIndexed { index, char ->
                if (index < 2) {
                    setSelection(2)
                } else if (char.isDigit()) {
                    setSelection(index + 1)
                }
            }
            addTextChangedListener(this)
        }

        override fun afterTextChanged(p0: Editable?) {}
    })
}