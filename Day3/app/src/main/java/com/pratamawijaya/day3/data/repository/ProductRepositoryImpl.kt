package com.pratamawijaya.day3.data.repository

import com.pratamawijaya.day3.data.MyAppServices
import com.pratamawijaya.day3.data.entity.Product
import retrofit2.Call

class ProductRepositoryImpl : ProductRepository {

    override fun getProducts(): Call<List<Product>> {
        return MyAppServices.create().getProducts()
    }

//    override fun getProduct(id: Int): Product {
//    }

    override fun saveProduct(): Boolean {
        return false
    }

    override fun deleteProduct(id: Int): Boolean {
        return false
    }
}