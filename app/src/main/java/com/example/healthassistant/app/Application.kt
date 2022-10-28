package com.example.healthassistant.api

import android.app.Application
import android.content.Context

class App : Application() {

    init {
        instance = this
    }

    companion object{
        private var instance: Application? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {

        //Build Room

        //Build Retrofit

        //Instantiate SharedPrefs


        super.onCreate()

    }

}

