package com.pratamawijaya.day4.ui.detail

import com.pratamawijaya.day4.data.model.ItemModel

interface DetailItemView {
    fun displayData(data: ItemModel)
}