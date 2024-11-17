package com.example.login_resikel.Room

import android.content.Context

class KeranjangRepository(private val keranjangDao: KeranjangDAO) {

    suspend fun insertKeranjang(keranjang: Keranjang) {
        keranjangDao.insert(keranjang)
    }

    suspend fun getAllKeranjang(): List<Keranjang> {
        return keranjangDao.getAllKeranjang()
    }

    suspend fun addOrUpdateItem(item: Keranjang) {
        if (keranjangDao.itemExists(item.itemName) > 0) {
            keranjangDao.increaseQty(item.itemName)
        } else {
            keranjangDao.insert(item)
        }
    }

    suspend fun deleteOrUpdateItem(item: Keranjang) {
        if (keranjangDao.itemExists(item.itemName) > 1) {
            keranjangDao.decreaseQty(item.itemName)
        } else {
            keranjangDao.delete(item)
        }
    }

    suspend fun getTotalQuantity(): Int{
        return keranjangDao.getTotalQty() ?: 0
    }

}