package com.example.login_resikel.Room

import androidx.room.*
@Dao
interface KeranjangDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(keranjang: Keranjang)

    @Update
    suspend fun update(keranjang: Keranjang)

    @Delete
    suspend fun delete(keranjang: Keranjang)

    @Query("SELECT * FROM tabel_keranjang")
    suspend fun getAllKeranjang(): List<Keranjang>

    @Query("SELECT * FROM tabel_keranjang WHERE id = :itemId")
    suspend fun getKeranjangById(itemId: Int): Keranjang?

    @Query("UPDATE tabel_keranjang SET quantity = quantity + 1 WHERE itemName = :inputName")
    suspend fun increaseQty(inputName: String)

    @Query("UPDATE tabel_keranjang SET quantity = CASE WHEN quantity > 0 THEN quantity - 1 ELSE 0 END WHERE id = :inputName")
    suspend fun decreaseQty(inputName: String)

    @Query("SELECT COUNT(*) FROM tabel_keranjang WHERE itemName = :inputName")
    suspend fun itemExists(inputName: String): Int

    @Query("SELECT SUM(quantity) FROM tabel_keranjang")
    suspend fun getTotalQty(): Int
}