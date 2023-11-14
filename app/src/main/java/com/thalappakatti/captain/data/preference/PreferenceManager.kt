/*
 * Created by Nethaji V on 31/01/22, 9:17 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 9:17 PM
 */

package com.thalappakatti.captain.data.preference

import android.content.Context
import android.content.SharedPreferences
import com.thalappakatti.captain.di.utility.Pref.CAPTAIN_SHARED_PREFERENCES
import com.thalappakatti.captain.di.utility.Pref.IS_LOGGED_IN

class PreferenceManager(context: Context) : IPreferenceManager {

    val pref: SharedPreferences = context.getSharedPreferences(CAPTAIN_SHARED_PREFERENCES, Context.MODE_PRIVATE)

    override fun saveIsLoggedIn(verifyStatus: Boolean) =
        pref.edit().putBoolean(IS_LOGGED_IN, verifyStatus).apply()

    override fun getIsLoggedIn() = pref.getBoolean(IS_LOGGED_IN, false)

    override fun clearLogin() = pref.edit().clear().apply();

}