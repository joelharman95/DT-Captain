/*
 * Created by Nethaji V on 31/01/22, 4:35 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 4:35 PM
 */

package com.thalappakatti.captain.di.utility

sealed class Resource<out T> {
    data class Success<out T>(val value: T) : Resource<T>()
    data class Failure(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val errorBody: String?
    ) : Resource<Nothing>()

    object Loading : Resource<Nothing>()
}