package com.pratamawijaya.day4.ui.rvitem

import com.pratamawijaya.day4.R
import com.pratamawijaya.day4.data.model.ItemModel
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_rv.view.*

class ItemRv(private val itemModel: ItemModel) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        val tvName = viewHolder.itemView.itemName

        tvName.text = itemModel.displayName
    }

    override fun getLayout(): Int {
        return R.layout.item_rv
    }

}