package com.example.login_resikel.Room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabel_keranjang")
data class Keranjang(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val itemName: String,
    val quantity: Int
)
