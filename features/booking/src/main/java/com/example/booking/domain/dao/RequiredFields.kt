package com.example.booking.domain.dao

import com.google.android.material.textfield.TextInputEditText

data class RequiredFields(
    val email: TextInputEditText,
    val phone: TextInputEditText,
    val tourists: MutableList<TouristFields>
) {
    fun anyBlank(): Boolean {
        if (getPhoneNumber().isBlank()) return true
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.text ?: "").matches()) return true
        getFields().forEach {
            if (it.text?.isBlank() != false) {
                return true
            }
        }
        return false
    }

    fun setErrorIfAnyBlank() {
        getFields().forEach {
            if (it.text?.isBlank() != false) {
                it.error = "Заполните поле"
            } else {
                it.error = null
            }
        }
    }

    private fun getPhoneNumber() = (phone.text ?: "")
        .filter { it.isDigit() }
        .removePrefix("+7")

    private fun getFields(): MutableList<TextInputEditText> {
        val touristFieldsList = mutableListOf(email, phone)
        tourists.forEach {
            touristFieldsList.addAll(
                listOf(
                    it.nameEditText,
                    it.surnameEditText,
                    it.birthdateEditText,
                    it.citizenshipEditText,
                    it.internationalPassportNumberEditText,
                    it.internationalPassportValidityEditText,
                )
            )
        }
        return touristFieldsList
    }
}

data class TouristFields(
    val nameEditText: TextInputEditText,
    val surnameEditText: TextInputEditText,
    val birthdateEditText: TextInputEditText,
    val citizenshipEditText: TextInputEditText,
    val internationalPassportNumberEditText: TextInputEditText,
    val internationalPassportValidityEditText: TextInputEditText,
)