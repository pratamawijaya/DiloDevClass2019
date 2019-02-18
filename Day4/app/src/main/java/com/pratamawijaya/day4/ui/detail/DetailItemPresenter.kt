package com.pratamawijaya.day4.ui.detail

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.StringRequestListener
import com.github.ajalt.timberkt.d
import com.github.ajalt.timberkt.e
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.pratamawijaya.day4.data.DetailItemResponse
import com.pratamawijaya.day4.utils.Const

class DetailItemPresenter(val view: DetailItemView) {


    var gson: Gson = GsonBuilder().create()

    fun getDetailItem(name: String) {
        if (name.isNotEmpty()) {
            val url = Const.GET_ITEM_LATEST_DATA + name
            d { "get detail url $url" }
            AndroidNetworking.get(url)
                .setTag("GET_ALL")
                .setPriority(Priority.IMMEDIATE)
                .build()
                .setAnalyticsListener { timeTakenInMillis, bytesSent, bytesReceived, isFromCache ->
                    d { "time take in millis $timeTakenInMillis" }
                    d { "is from cache $isFromCache" }
                }
                .getAsString(object : StringRequestListener {
                    override fun onResponse(response: String?) {
                        response.let {
                            val response: DetailItemResponse = gson.fromJson(it, DetailItemResponse::class.java)
                            view.displayData(response.data.data)
                        }
                    }

                    override fun onError(anError: ANError?) {
                        e { "error ${anError?.message}" }
                    }

                })
        }

    }
}