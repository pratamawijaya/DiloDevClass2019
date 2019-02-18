package com.pratamawijaya.day4.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * android extension for load image from url
 */
fun ImageView.loadUrl(url: String) {
    if (url.isEmpty())
        return

    Picasso.get().load(url)
        .into(this)
}