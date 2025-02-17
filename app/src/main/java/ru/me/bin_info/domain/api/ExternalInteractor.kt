package ru.me.bin_info.domain.api

interface ExternalInteractor {
    fun openMap(lat: Float, lon: Float)
    fun openUrl(url: String)
    fun openDial(phone: String)
}