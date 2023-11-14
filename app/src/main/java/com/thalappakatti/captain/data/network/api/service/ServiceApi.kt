/*
 * Created by Nethaji V on 31/01/22, 4:32 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 4:32 PM
 */

package com.thalappakatti.captain.data.network.api.service

import com.thalappakatti.captain.data.network.api.response.ResServices
import com.thalappakatti.captain.di.utility.API.URL_REQUEST
import retrofit2.Response
import retrofit2.http.GET

interface ServiceApi {

    @GET(URL_REQUEST)
    suspend fun getServices(
//        @Header(AUTHORIZATION) auth: String = "CIGfMA0GCSqGSIb3DQEBAQdqDup1pgSc0tQUMQUAA4GNADCBiQKBgQD3apAg6H2i",
    ): Response<ResServices>

    @GET(URL_REQUEST)
    suspend fun getService(): ResServices
}