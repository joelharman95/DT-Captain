/*
 * Created by Nethaji V on 31/01/22, 4:30 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 4:30 PM
 */

package com.thalappakatti.captain.data.network.api.response

import com.google.gson.annotations.SerializedName

data class ResError(
    @SerializedName("code") val code: Int? = null,
    @SerializedName("message") val message: String? = null,
    @SerializedName("status") val status: String? = null
)