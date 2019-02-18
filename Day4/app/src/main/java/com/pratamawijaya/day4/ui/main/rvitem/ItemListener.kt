package com.pratamawijaya.day4.ui.main.rvitem

import com.pratamawijaya.day4.data.model.ItemModel

interface ItemListener {
    fun onItemClick(item: ItemModel)
}