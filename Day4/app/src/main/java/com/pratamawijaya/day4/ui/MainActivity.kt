package com.pratamawijaya.day4.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.ajalt.timberkt.d
import com.github.ajalt.timberkt.e
import com.pratamawijaya.day4.R
import com.pratamawijaya.day4.data.model.ItemModel

class MainActivity : AppCompatActivity(), MainView {

    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
        presenter.getTrendingItem()
        presenter.getAllItem()
    }

    override fun displayItemTrending(item_list: List<ItemModel>) {
        item_list.map {
            d { "trending item ${it.name}" }
        }
    }

    override fun displayError(message: String?) {
        e { "error $message" }
    }

    override fun displayAllItems(item_list: List<ItemModel>) {
        item_list.map {
            d { "all items ${it.name}" }
        }
    }
}
