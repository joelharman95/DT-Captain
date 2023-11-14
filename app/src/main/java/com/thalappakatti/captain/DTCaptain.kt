/*
 * Created by Nethaji V on 31/01/22, 4:22 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 4:22 PM
 */

package com.thalappakatti.captain

import android.app.Application
import android.net.ConnectivityManager
import com.facebook.stetho.Stetho
import com.thalappakatti.captain.di.DB_MODULE
import com.thalappakatti.captain.di.NETWORKING_MODULE
import com.thalappakatti.captain.di.REPOSITORY_MODULE
import com.thalappakatti.captain.di.VIEW_MODEL_MODULE
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class DTCaptain : Application() {

    override fun onCreate() {
        super.onCreate()
        app = this
        Stetho.initializeWithDefaults(this)
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@DTCaptain)
            loadKoinModules(REQUIRED_MODULE)
        }
    }

    companion object {
        val REQUIRED_MODULE = listOf(
            NETWORKING_MODULE,
            REPOSITORY_MODULE,
            VIEW_MODEL_MODULE,
            DB_MODULE
        )
        lateinit var app: Application

        fun isConnected(): Boolean {
            val connectivityManager =
                app.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
            return connectivityManager.activeNetworkInfo != null
        }
    }

}