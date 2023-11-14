/*
 * Created by Nethaji V on 31/01/22, 10:03 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 10:03 PM
 */

package com.thalappakatti.captain.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.thalappakatti.captain.data.db.dao.CartDao
import com.thalappakatti.captain.data.db.dao.UserDao
import com.thalappakatti.captain.data.db.schema.Product
import com.thalappakatti.captain.data.db.schema.User

@Database(
    entities = [
        Product::class,
        User::class
    ], version = 3, exportSchema = true
)
abstract class DTCaptainDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
    abstract fun userDao(): UserDao

    companion object Factory {
        private const val DATABASE_NAME = "dt_captain.db"
        fun create(c: Context): DTCaptainDatabase =
            Room.databaseBuilder(c, DTCaptainDatabase::class.java, DATABASE_NAME).build()
    }

}