package com.pratamawijaya.day3.ui.product

import com.pratamawijaya.day3.data.entity.Product

interface ProductListView {
    fun showLoading()
    fun hideLoading()
    fun showData(listProduct: List<Product>)
    fun showError(errorMsg: String)
}