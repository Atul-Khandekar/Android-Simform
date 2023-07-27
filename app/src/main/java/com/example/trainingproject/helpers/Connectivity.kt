package com.example.trainingproject.helpers

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.example.trainingproject.constants.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

object Connectivity {

    private fun hasNetworkAvailable(context: Context): Boolean {
        val service = Context.CONNECTIVITY_SERVICE
        val manager = context.getSystemService(service) as ConnectivityManager?
        val network = manager?.activeNetwork
        Log.d("Networktest","hasNetworkAvailable: ${(network != null)}" )
        return (network != null)
    }

    suspend fun hasInternetConnected(context: Context): Boolean {
        if (hasNetworkAvailable(context)) {
            try {
                val connection = withContext(Dispatchers.IO) {
                    URL(Constants.CONNECTIVITY_SERVER).openConnection()
                } as HttpURLConnection
                connection.setRequestProperty("User-Agent", "Test")
                connection.setRequestProperty("Connection", "close")
                connection.connectTimeout = 1500 // configurable
                withContext(Dispatchers.IO) {
                    connection.connect()
                    Log.d("Internet test", "hasInternetConnected: ${(connection.responseCode == 200)}")
                }

                return (connection.responseCode == 200)
            } catch (e: IOException) {
                Log.d("internet error", "Error checking internet connection", e)
            }
        } else {
            Log.d("Network test", "No network available!")
        }
        Log.d("NO Internet","No Internet connected")
        return false
    }
}