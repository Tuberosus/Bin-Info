package ru.me.bin_info.domain.impl

import ru.me.bin_info.domain.api.ExternalInteractor
import ru.me.bin_info.domain.api.ExternalNavigator

class ExternalInteractorImpl(
    private val navigator: ExternalNavigator
) : ExternalInteractor {

    override fun openMap(lat: Float, lon: Float) {
        navigator.openMap(lat, lon)
    }

    override fun openUrl(url: String) {
        navigator.openUrl(url)
    }

    override fun openDial(phone: String) {
        navigator.openDial(phone)
    }
}