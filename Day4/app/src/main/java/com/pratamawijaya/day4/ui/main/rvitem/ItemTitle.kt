package com.pratamawijaya.day4.ui.main.rvitem

import com.pratamawijaya.day4.R
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_title.view.*

class ItemTitle(val title: String) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        val tvTitle = viewHolder.itemView.tvTitle

        tvTitle.text = title
    }

    override fun getLayout(): Int {
        return R.layout.item_title
    }
}