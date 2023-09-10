package com.example.core.dao

data class TouristDao(
    var id: Long,
    var name: String = "",
    var surname: String = "",
    var birthDate: String = "",
    var citizenship: String = "",
    var internationalPassportNumber: String = "",
    var internationalPassportValidity: String = ""
) {
    fun getTitle() = when (id) {
        1L -> "Первый"
        2L -> "Второй"
        3L -> "Третий"
        4L -> "Четвертый"
        5L -> "Пятый"
        6L -> "Шестой"
        7L -> "Седьмой"
        8L -> "Восьмой"
        9L -> "Девятый"
        10L -> "Десятый"
        11L -> "Одинадцатый"
        12L -> "Двенадцатый"
        13L -> "Тренадцатый"
        14L -> "Четырнадцатый"
        15L -> "Пятнадцатый"
        16L -> "Шестнадцатый"
        17L -> "Семнадцатый"
        18L -> "Восемнадцатый"
        19L -> "Девятнадцатый"
        20L -> "Двадцатый"
        else -> id.toString()
    }.plus(" турист")
}
