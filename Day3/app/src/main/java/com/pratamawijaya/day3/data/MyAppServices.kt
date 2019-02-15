package com.pratamawijaya.day3.data

import com.pratamawijaya.day3.data.entity.Product
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyAppServices {

    // https://api.myjson.com/bins/1585qw

    @GET("bins/kvcko")
    fun getProducts(): Call<List<Product>>

    companion object Factory {
        fun create(): MyAppServices {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.myjson.com/")
                .build()

            return retrofit.create(MyAppServices::class.java)
        }
    }
}