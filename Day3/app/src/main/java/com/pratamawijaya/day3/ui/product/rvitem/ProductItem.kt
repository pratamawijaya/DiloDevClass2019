package com.pratamawijaya.day3.ui.product.rvitem

import com.pratamawijaya.day3.R
import com.pratamawijaya.day3.data.entity.Product
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_product.view.*

interface ProductListener {
    fun onProductClick(product: Product)
}

class ProductItem(val product: Product,
                  val listener: ProductListener) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        val tvProductName = viewHolder.itemView.tvProductName
        val tvProductPrice = viewHolder.itemView.tvProductPrice

        tvProductName.text = product.nama
        tvProductPrice.text = "${product.harga}"

        viewHolder.itemView.setOnClickListener {
            listener.onProductClick(product)
        }
    }

    override fun getLayout(): Int {
        return R.layout.item_product
    }
}