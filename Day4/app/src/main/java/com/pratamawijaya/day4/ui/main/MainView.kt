package com.pratamawijaya.day4.ui.main

import com.pratamawijaya.day4.data.model.ItemModel

interface MainView {
    fun displayItemTrending(item_list: List<ItemModel>)
    fun displayError(message: String?)
    fun displayAllItems(item_list: List<ItemModel>)
}