package com.pratamawijaya.day4.data

import com.pratamawijaya.day4.data.model.ItemModel

data class TrendingItemResponse(
    val success: Boolean,
    val data: TrendingItem
)

data class TrendingItem(
    val item_list: List<ItemModel>
)