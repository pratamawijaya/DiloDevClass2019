package com.pratamawijaya.day4.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.loadUrl(url: String) {
    if (url.isEmpty())
        return

    Picasso.get().load(url)
        .into(this)
}