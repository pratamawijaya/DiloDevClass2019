package com.pratamawijaya.day3.data.entity

import java.math.BigDecimal

data class Product(
    val id: Int,
    val nama: String,
    val gambar: String,
    val harga: BigDecimal
)