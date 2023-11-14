/*
 * Created by Nethaji V on 31/01/22, 10:04 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 10:04 PM
 */

package com.thalappakatti.captain.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.thalappakatti.captain.data.db.schema.User

@Dao
abstract class UserDao {

    @Query("SELECT * FROM user LIMIT 1")
    abstract suspend fun getUser(): User

    @Query("SELECT * FROM user LIMIT 1")
    abstract fun getUserLiveData(): LiveData<User?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    protected abstract fun insertUser(user: User)
}