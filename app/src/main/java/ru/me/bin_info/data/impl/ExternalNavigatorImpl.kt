package ru.me.bin_info.data.impl

import android.content.Context
import android.content.Intent
import android.net.Uri
import ru.me.bin_info.domain.api.ExternalNavigator
import java.util.Locale

class ExternalNavigatorImpl(
    private val context: Context
) : ExternalNavigator {

    override fun openMap(lat: Float, lon: Float) {
        val intent = Intent().apply {
            action = Intent.ACTION_VIEW
            data = Uri.parse(String.format(Locale.ENGLISH, "geo:%f,%f", lat, lon))
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        context.startActivity(intent)
    }

    override fun openUrl(url: String) {
        val intent = Intent().apply {
            action = Intent.ACTION_VIEW
            data = Uri.parse(url)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        context.startActivity(intent)
    }

    override fun openDial(phone: String) {
        val intent = Intent().apply {
            action = Intent.ACTION_DIAL
            data = Uri.parse(String.format(Locale.ENGLISH, "tel:s%", phone))
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        context.startActivity(intent)
    }
}