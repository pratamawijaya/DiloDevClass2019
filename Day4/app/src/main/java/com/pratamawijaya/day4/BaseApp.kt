package com.pratamawijaya.day4

import android.app.Application
import com.androidnetworking.AndroidNetworking
import okhttp3.OkHttpClient
import timber.log.Timber

class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // init FAN
        val okHttp = OkHttpClient().newBuilder()
            .addInterceptor { chain ->
                // add header in every request
                val request = chain.request().newBuilder()
                    .addHeader("Origin", "https://poporing.life")
                    .build()
                chain.proceed(request)
            }
            .build()
        AndroidNetworking.initialize(this, okHttp)

        Timber.plant(Timber.DebugTree())
    }
}