package com.bartoszkrol.myanimals.app

import android.app.Application
import android.content.Context

class MyAnimalsApplication : Application() {

    companion object {
        private lateinit var instance: MyAnimalsApplication

        fun getAppContext(): Context = instance.applicationContext
    }

    override fun onCreate() {
        instance = this
        super.onCreate()

    }

}