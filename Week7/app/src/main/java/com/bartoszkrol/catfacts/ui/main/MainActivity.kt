package com.bartoszkrol.catfacts.ui.main

import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bartoszkrol.catfacts.App
import com.bartoszkrol.catfacts.R
import com.bartoszkrol.catfacts.model.CatFact
import com.bartoszkrol.catfacts.model.Failure
import com.bartoszkrol.catfacts.model.Success
import com.bartoszkrol.catfacts.networking.NetworkStatusChecker
import com.bartoszkrol.catfacts.viewmodel.CatFactsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val remoteApi = App.remoteApi
    private val networkStatusChecker by lazy {
        NetworkStatusChecker(getSystemService(ConnectivityManager::class.java))
    }
    private val catFactAdapter = CatFactAdapter()
    private lateinit var catFactsViewModel: CatFactsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        catFactsViewModel = ViewModelProvider(this).get(CatFactsViewModel::class.java)

        catFactsRecyclerView.layoutManager = LinearLayoutManager(this)
        catFactsRecyclerView.adapter = catFactAdapter

        catFactsViewModel.getCatFacts().observe(this, Observer<List<CatFact>> { catFacts ->
            catFactAdapter.setCatFacts(catFacts ?: emptyList())
        })

        getAllCatFacts()
    }

    private fun getAllCatFacts() {
        networkStatusChecker.performIfConnectedToInternet {
            GlobalScope.launch(Dispatchers.Main) {
                val result = remoteApi.getCatFacts()

                if (result is Success) {
                    onGetCatFactsSuccess(result.data)
                } else {
                    if (result is Failure) {
                        result.error?.printStackTrace()
                    }
                    onGetCatFactsFailed()
                }
            }
        }
    }

    private fun onGetCatFactsSuccess(catFacts: List<CatFact>) {
        catFactsViewModel.insertCatFacts(catFacts)
    }

    private fun onGetCatFactsFailed() {
        println("failed to download data")
    }

}