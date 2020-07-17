package com.bartoszkrol.catfacts.ui.main

import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bartoszkrol.catfacts.App
import com.bartoszkrol.catfacts.R
import com.bartoszkrol.catfacts.model.CatFact
import com.bartoszkrol.catfacts.model.Success
import com.bartoszkrol.catfacts.networking.NetworkStatusChecker
import com.bartoszkrol.catfacts.utils.snack
import com.bartoszkrol.catfacts.viewmodel.CatFactsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

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
        catFactsRecyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        catFactsRecyclerView.adapter = catFactAdapter


        catFactsViewModel.getCatFacts().observe(this, Observer<List<CatFact>> { catFacts ->
            catFactAdapter.setCatFacts(catFacts ?: emptyList())
        })

        getAllCatFacts()
    }

    /**
     * Download data from the API
     */
    private fun getAllCatFacts() {
        networkStatusChecker.performIfConnectedToInternet( {
            CoroutineScope(Dispatchers.IO).launch {
                val result = remoteApi.getCatFacts()

                withContext(Dispatchers.Main) {
                    if (result is Success) {
                        onGetCatFactsSuccess(result.data)
                    } else {
                        onGetCatFactsFailed()
                    }
                }
            }
        }, {
            catFactsRecyclerView.snack(getString(R.string.error_no_internet_problem))
        })
    }

    /**
     * Add new data to the database
     */
    private fun onGetCatFactsSuccess(catFacts: List<CatFact>) {
        catFactsViewModel.insertCatFacts(catFacts)
    }

    /**
     * Shows downloading error
     */
    private fun onGetCatFactsFailed() {
        catFactsRecyclerView.snack(getString(R.string.error_server_problem))
    }

}