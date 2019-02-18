package com.pratamawijaya.day4.ui.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.ajalt.timberkt.d
import com.pratamawijaya.day4.R
import com.pratamawijaya.day4.data.model.ItemModel
import com.pratamawijaya.day4.utils.loadUrl
import kotlinx.android.synthetic.main.activity_detail_item.*

class DetailItemActivity : AppCompatActivity(), DetailItemView {

    lateinit var presenter: DetailItemPresenter

    private var item: ItemModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_item)

        item = intent.getParcelableExtra<ItemModel>("item")

        presenter = DetailItemPresenter(this)

        item?.let {
            supportActionBar?.title = "${it.displayName}"
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            presenter.getDetailItem(it.name ?: "")
        }
        d { "item name ${item?.name}" }

    }

    override fun displayData(data: ItemModel) {
        val imgUrl = "https://static.poporing.life/items/${item?.name}.png"

        d { "load url $imgUrl " }
        imgItem.loadUrl(imgUrl)

        tvPrice.text = "Price ${data.price} Zenny"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
