package com.pratamawijaya.day4.ui

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.StringRequestListener
import com.github.ajalt.timberkt.d
import com.github.ajalt.timberkt.e
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.pratamawijaya.day4.data.TrendingItemResponse
import com.pratamawijaya.day4.utils.Const

class MainPresenter(val view: MainView) {

    var gson: Gson = GsonBuilder().create()

    fun getAllItem() {
        AndroidNetworking.get(Const.GET_ITEM_LIST)
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
                        val itemResponse:TrendingItemResponse = gson.fromJson(it, TrendingItemResponse::class.java)
                        view.displayAllItems(itemResponse.data.item_list)
                    }
                }

                override fun onError(anError: ANError?) {
                    handleError(anError)
                }
            })
    }

    fun getTrendingItem() {
        AndroidNetworking.get(Const.GET_TRENDING)
            .setTag("GET_TRENDING")
            .setPriority(Priority.IMMEDIATE)
            .build()
            .setAnalyticsListener { timeTakenInMillis, _, _, isFromCache ->
                d { "time take in millis $timeTakenInMillis" }
                d { "is from cache $isFromCache" }
            }
            .getAsString(object : StringRequestListener {
                override fun onResponse(response: String?) {
                    response.let {
                        // pada block ini response tidak akan bernilai null
                        val itemResponse: TrendingItemResponse = gson.fromJson(it, TrendingItemResponse::class.java)
                        view.displayItemTrending(itemResponse.data.item_list)
                    }
                }

                override fun onError(anError: ANError?) {
                    handleError(anError)
                }
            })
    }

    private fun handleError(anError: ANError?) {
        e { "error ${anError?.message}" }
        view.displayError(anError?.message)
    }

}