package com.bartoszkrol.catfacts.networking

import android.net.ConnectivityManager
import android.net.NetworkCapabilities

/**
 * Checks the internet connection
 */
class NetworkStatusChecker(private val connectivityManager: ConnectivityManager?) {

    inline fun performIfConnectedToInternet(action: () -> Unit, noInternetAction: () -> Unit) {
        if (hasInternetConnection()) {
            action()
        } else {
            noInternetAction()
        }
    }

    fun hasInternetConnection(): Boolean {
        val network = connectivityManager?.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false

        return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN)
    }

}