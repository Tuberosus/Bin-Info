package ru.me.bin_info.domain.models

import ru.me.bin_info.data.dto.bin_info.Bank

data class Bin(
    val country: String,
    val lon: Int,
    val lat: Int,
    val cardType: String,
    val bank: Bank
)