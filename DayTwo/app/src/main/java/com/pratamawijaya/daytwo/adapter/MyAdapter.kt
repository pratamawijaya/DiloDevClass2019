package com.pratamawijaya.daytwo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pratamawijaya.daytwo.R
import kotlinx.android.synthetic.main.item_layout_product.view.*

class MyAdapter(val items: List<String>) : RecyclerView.Adapter<MyAdapter.MyHolder>() {

    // create holder view untuk tiap item
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): MyHolder {
        // inflate view untuk item

        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_layout_product, viewGroup, false)

        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        // item ada berapa banyak ?
        return items.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bindItem(items[position])
    }

    // inner class holder
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        val txtTitle = itemView.findViewById<TextView>(R.id.tvTitle)

        fun bindItem(data: String) {
            itemView.tvTitle.text = data
        }
    }
}