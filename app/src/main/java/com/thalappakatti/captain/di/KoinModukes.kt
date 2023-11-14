/*
 * Created by Nethaji V on 31/01/22, 4:35 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 4:35 PM
 */

package com.thalappakatti.captain.di

import android.content.Context
import com.thalappakatti.captain.data.network.api.service.ServiceApi
import com.thalappakatti.captain.data.network.http.HttpClientManager
import com.thalappakatti.captain.data.network.http.createApi
import com.thalappakatti.captain.data.preference.IPreferenceManager
import com.thalappakatti.captain.data.repository.ServiceRepository
import com.thalappakatti.captain.data.viewmodel.*
import com.thalappakatti.captain.data.db.DTCaptainDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val NETWORKING_MODULE = module {
    single { HttpClientManager.newInstance() }
    single { get<HttpClientManager>().createApi<ServiceApi>() }
}

val REPOSITORY_MODULE = module {
    single { ServiceRepository.create(get()) }
}

val VIEW_MODEL_MODULE = module {
    viewModel { SplashViewModel(get()) }
    viewModel { LoginViewModel(get(), getPreference(androidContext())) }
    viewModel { StoreSelectionViewModel(get()) }
    viewModel { ServiceViewModel(get()) }
    viewModel { HomeViewModel() }
    viewModel { SlideshowViewModel() }
    viewModel { GalleryViewModel() }
}

val DB_MODULE = module {
    single { DTCaptainDatabase.create(androidContext()) }
    single { get<DTCaptainDatabase>().cartDao() }
}

fun getPreference(androidContext: Context): IPreferenceManager {
    return IPreferenceManager.getPrefInstance(androidContext)
}