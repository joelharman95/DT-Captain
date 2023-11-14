/*
 * Created by Nethaji V on 31/01/22, 10:02 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 10:02 PM
 */

package com.thalappakatti.captain.data.db.dao

import androidx.room.*
import androidx.room.Dao
import com.thalappakatti.captain.data.db.schema.Product

@Dao
interface CartDao {
    @Query("SELECT * FROM products")
    fun getAll(): List<Product>

    @Query("SELECT * FROM products where id LIKE :key")
    fun get(key: String): List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg products: Product)

    @Delete
    fun delete(vararg product: Product)

    @Query("DELETE FROM products")
    fun deleteAll()


}