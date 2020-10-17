package cz.verunka.droid.ghibliki.services.extensions

import android.content.Context
import cz.verunka.droid.ghibliki.R
import cz.verunka.droid.ghibliki.services.utils.AppResult

val Any.TAG: String
    get() {
        val tag = javaClass.simpleName
        return if (tag.length <= 23) tag else tag.substring(0, 23)
    }

fun Context.noNetworkConnectivityError(): AppResult.Error {
    return AppResult.Error(Exception(this.resources.getString(R.string.no_network_connectivity)))
}