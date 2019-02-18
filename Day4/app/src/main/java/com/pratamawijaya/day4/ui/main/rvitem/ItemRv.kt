package com.pratamawijaya.day4.ui.main.rvitem

import com.github.ajalt.timberkt.d
import com.pratamawijaya.day4.R
import com.pratamawijaya.day4.data.model.ItemModel
import com.pratamawijaya.day4.utils.loadUrl
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_rv.view.*

class ItemRv(
    private val itemModel: ItemModel,
    val listener: ItemListener
) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        val tvName = viewHolder.itemView.itemName
        val imgItem = viewHolder.itemView.itemImg

        tvName.text = itemModel.displayName
        val url = "https://static.poporing.life/items/${itemModel.name}.png"

        d { "load url $url " }
        imgItem.loadUrl(url)

        viewHolder.itemView.setOnClickListener { listener.onItemClick(itemModel) }
    }

    override fun getLayout(): Int {
        return R.layout.item_rv
    }

}