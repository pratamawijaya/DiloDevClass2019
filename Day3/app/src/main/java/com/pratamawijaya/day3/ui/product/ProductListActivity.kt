package com.pratamawijaya.day3.ui.product

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.pratamawijaya.day3.R
import com.pratamawijaya.day3.data.entity.Product
import com.pratamawijaya.day3.data.repository.ProductRepositoryImpl

class ProductListActivity : AppCompatActivity(), ProductListView {

    lateinit var presenter: ProductListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val productRepo = ProductRepositoryImpl()


        presenter = ProductListPresenter(this, productRepo)
        presenter.getProducts()
    }

    override fun showLoading() {
        // todo : show loading bar
    }

    override fun hideLoading() {
        // todo : hide loading bar
    }

    override fun showData(listProduct: List<Product>) {
        // todo : show data to recyclerview

        Log.d("tag", "data size ${listProduct.size}")

        listProduct.map {
            Log.d("tag", "data nya ${it.nama}")
        }
    }
}
