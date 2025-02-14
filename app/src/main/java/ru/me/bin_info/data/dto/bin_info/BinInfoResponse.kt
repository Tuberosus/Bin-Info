package ru.me.bin_info.data.dto.bin_info

import ru.me.bin_info.data.dto.Response

class BinInfoResponse(
    val bank: Bank,
    val brand: String,
    val country: Country,
    val number: Number,
    val prepaid: Boolean,
    val scheme: String,
    val type: String
) : Response()