package com.pratamawijaya.day4.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.github.ajalt.timberkt.d
import com.github.ajalt.timberkt.e
import com.pratamawijaya.day4.R
import com.pratamawijaya.day4.data.model.ItemModel
import com.pratamawijaya.day4.ui.rvitem.ItemRv
import com.pratamawijaya.day4.ui.rvitem.ItemRvTrending
import com.pratamawijaya.day4.ui.rvitem.ItemTitle
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    lateinit var presenter: MainPresenter

    val mainAdapter = GroupAdapter<ViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainAdapter
            addItemDecoration(DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL))
        }

        presenter = MainPresenter(this)
        presenter.getTrendingItem()

    }

    override fun displayItemTrending(item_list: List<ItemModel>) {
        mainAdapter.add(ItemTitle("Trending Item"))
        item_list.map {
            d { "trending item ${it.name}" }
            mainAdapter.add(ItemRvTrending(it))
        }

        // ambil semua item
        presenter.getAllItem()
    }

    override fun displayError(message: String?) {
        e { "error $message" }
    }

    override fun displayAllItems(item_list: List<ItemModel>) {
        mainAdapter.add(ItemTitle("All Item"))
        item_list.map {
            d { "all items ${it.name}" }
            mainAdapter.add(ItemRv(it))
        }
    }
}
