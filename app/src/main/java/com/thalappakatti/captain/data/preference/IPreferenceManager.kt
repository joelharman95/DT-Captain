/*
 * Created by Nethaji V on 31/01/22, 9:17 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 9:17 PM
 */

package com.thalappakatti.captain.data.preference

import android.content.Context

interface IPreferenceManager {

    fun saveIsLoggedIn(verifyStatus: Boolean)
    fun getIsLoggedIn(): Boolean
    fun clearLogin()

    companion object Factory {
        fun getPrefInstance(context: Context): IPreferenceManager = PreferenceManager(context)
    }
}