package com.bartoszkrol.catfacts.ui

import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bartoszkrol.catfacts.App
import com.bartoszkrol.catfacts.R
import com.bartoszkrol.catfacts.model.CatFact
import com.bartoszkrol.catfacts.model.Success
import com.bartoszkrol.catfacts.networking.NetworkStatusChecker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val remoteApi = App.remoteApi
    private val networkStatusChecker by lazy {
        NetworkStatusChecker(getSystemService(ConnectivityManager::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getAllCatFacts()
    }

    private fun getAllCatFacts() {
        networkStatusChecker.performIfConnectedToInternet {
            GlobalScope.launch(Dispatchers.Main) {
                val result = remoteApi.getCatFacts()

                if (result is Success) {
                    onGetCatFactsSuccess(result.data)
                } else {
                    onGetCatFactsFailed()
                }
            }
        }
    }

    private fun onGetCatFactsSuccess(catFacts: List<CatFact>) {

    }

    private fun onGetCatFactsFailed() {

    }

}