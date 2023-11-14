/*
 * Created by Nethaji V on 31/01/22, 10:04 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 10:04 PM
 */

package com.thalappakatti.captain.data.db.schema

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int? = -1,
    @ColumnInfo(name = "status")
    var status: String? = null,
    @ColumnInfo(name = "content")
    var content: String? = null,
    @ColumnInfo(name = "first_name")
    var firstName: String,
    @ColumnInfo(name = "last_name")
    var lastName: String,
    @ColumnInfo(name = "email")
    var email: String,
    @ColumnInfo(name = "phone_number")
    var phone: String? = null,
    @ColumnInfo(name = "birthday")
    var birthday: String? = null
) {
    fun fullName(): String = "$firstName $lastName"
}