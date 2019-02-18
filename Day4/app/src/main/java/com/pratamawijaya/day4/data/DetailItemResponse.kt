package com.pratamawijaya.day4.data

import com.pratamawijaya.day4.data.model.ItemModel

data class DetailItemResponse(
    val success: Boolean,
    val data: DetailItem
)

data class DetailItem(
    val item_name: String,
    val data: ItemModel
)