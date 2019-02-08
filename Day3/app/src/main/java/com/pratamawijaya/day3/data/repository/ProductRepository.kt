package com.pratamawijaya.day3.data.repository

import com.pratamawijaya.day3.data.entity.Product
import retrofit2.Call

interface ProductRepository {
    fun getProducts(): Call<List<Product>>

    //    fun getProduct(id: Int): Product
    fun saveProduct(): Boolean

    fun deleteProduct(id: Int): Boolean
}