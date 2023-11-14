/*
 * Created by Nethaji V on 31/01/22, 10:04 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 10:04 PM
 */

package com.thalappakatti.captain.data.db.schema

import androidx.room.Entity
import androidx.room.PrimaryKey

// Created on 30/11/19.


@Entity(tableName = "products")
data class Product(

    @PrimaryKey
    var id: Long,

    var name: String,

    var quantity: Int = 0,

    var price: Double

  )

