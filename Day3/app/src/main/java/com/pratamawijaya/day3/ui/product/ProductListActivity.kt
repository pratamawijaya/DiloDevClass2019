package com.pratamawijaya.day3.ui.product

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import com.pratamawijaya.day3.R
import com.pratamawijaya.day3.data.entity.Product
import com.pratamawijaya.day3.data.repository.ProductRepositoryImpl
import com.pratamawijaya.day3.ui.product.rvitem.ProductItem
import com.pratamawijaya.day3.ui.product.rvitem.ProductListener
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.activity_product_list.*
import org.jetbrains.anko.toast

class ProductListActivity : AppCompatActivity(), ProductListView, ProductListener {

    lateinit var presenter: ProductListPresenter

    val productAdapter = GroupAdapter<ViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val productRepo = ProductRepositoryImpl()

        // setup recyclerview
        rvProductList.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(this@ProductListActivity)
            addItemDecoration(DividerItemDecoration(this@ProductListActivity, LinearLayoutManager.VERTICAL))
        }

        rvProductList.setonscr

        presenter = ProductListPresenter(this, productRepo)
        presenter.getProducts()
    }

    override fun showLoading() {
        loading.visibility = VISIBLE
        rvProductList.visibility = GONE
    }

    override fun hideLoading() {
        loading.visibility = GONE
        rvProductList.visibility = VISIBLE
    }

    override fun showError(errorMsg: String) {
        // error
        loading.visibility = GONE
        rvProductList.visibility = GONE
        tvError.visibility = VISIBLE
    }

    override fun onProductClick(product: Product) {
        toast("Show ${product.nama}")
        // pindah activity
    }

    override fun showData(listProduct: List<Product>) {
        Log.d("tag", "data size ${listProduct.size}")

        listProduct.map {
            Log.d("tag", "data nya ${it.nama}")
            productAdapter.add(ProductItem(it, this))
        }
    }
}
