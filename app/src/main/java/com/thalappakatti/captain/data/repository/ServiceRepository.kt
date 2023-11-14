/*
 * Created by Nethaji V on 31/01/22, 4:35 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 4:35 PM
 */

package com.thalappakatti.captain.data.repository

import com.thalappakatti.captain.data.network.api.response.ResServices
import com.thalappakatti.captain.data.network.api.service.ServiceApi
import com.thalappakatti.captain.di.OnError
import com.thalappakatti.captain.di.OnSuccess
import com.thalappakatti.captain.di.utility.ResponseReceiver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ServiceRepository(private val api: ServiceApi) : ResponseReceiver {

    suspend fun getServices(
        onSuccess: OnSuccess<ResServices>,
        onError: OnError<Any>
    ) {
        withContext(Dispatchers.IO) {
            try {
                val response = api.getServices()
                if (response.isSuccessful) {
                    response.body()?.let {
                        if (it.status)
                            withContext(Dispatchers.Main) { onSuccess(it) }
                        else
                            withContext(Dispatchers.Main) { onError(it.status) }
                    }
                } else {
                    /*withContext(Dispatchers.Main) {
                        onError(  //  Customised server error
                            Gson().fromJson(
                                response.errorBody()?.string(), ResError::class.java
                            )
                        )
                    }*/
                    withContext(Dispatchers.Main) { onError(response.message().toString()) }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) { onError(e.message.toString()) }
            }
        }
    }

    suspend fun getService() = callApi { api.getService() }

    companion object Factory {
        fun create(api: ServiceApi) = ServiceRepository(api)
    }
}