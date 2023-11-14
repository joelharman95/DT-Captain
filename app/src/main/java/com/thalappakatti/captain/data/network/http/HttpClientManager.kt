/*
 * Created by Nethaji V on 31/01/22, 4:32 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 4:32 PM
 */

package com.thalappakatti.captain.data.network.http

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import com.thalappakatti.captain.di.utility.Extras
import com.thalappakatti.captain.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

private class HttpClientManagerImpl() : HttpClientManager {

    override val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                addNetworkInterceptor(StethoInterceptor())
                addInterceptor {
                    it.proceed(
                        it.request().newBuilder().addHeader(
                            Extras.AUTHORIZATION,
                            "CIGfMA0GCSqGSIb3DQEBAQdqDup1pgSc0tQUMQUAA4GNADCBiQKBgQD3apAg6H2i"
                        )
                            .build()
                    )
                }
                addInterceptor(
                    HttpLoggingInterceptor().apply {
                        this.level = HttpLoggingInterceptor.Level.BODY
                    }
                )
            }
        }
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            //  .callTimeout(25, TimeUnit.SECONDS)
            .build()
    }

    override val retrofit = Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .client(okHttpClient)
        .build()
}

inline fun <reified T> HttpClientManager.createApi(): T {
    return this.retrofit.create()
}

interface HttpClientManager {
    val okHttpClient: OkHttpClient
    val retrofit: Retrofit

    companion object {
        fun newInstance(): HttpClientManager = HttpClientManagerImpl()
    }
}