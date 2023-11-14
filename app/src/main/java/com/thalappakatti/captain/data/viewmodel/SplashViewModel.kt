/*
 * Created by Nethaji V on 31/01/22, 4:39 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 4:39 PM
 */

package com.thalappakatti.captain.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thalappakatti.captain.data.network.api.response.ResServices
import com.thalappakatti.captain.data.repository.ServiceRepository
import com.thalappakatti.captain.di.OnError
import com.thalappakatti.captain.di.OnSuccess
import com.thalappakatti.captain.di.utility.Resource
import kotlinx.coroutines.launch

class SplashViewModel(private val repository: ServiceRepository) : ViewModel() {

    private val _responseLiveData: MutableLiveData<Resource<ResServices>> = MutableLiveData()
    val responseLiveData: LiveData<Resource<ResServices>> get() = _responseLiveData

    fun getServices(
        onSuccess: OnSuccess<ResServices>,
        onError: OnError<Any>
    ) {
        viewModelScope.launch {
            repository.getServices(onSuccess, onError)
        }
    }

    fun getServices() {
        viewModelScope.launch {
            _responseLiveData.value = Resource.Loading
            _responseLiveData.value = repository.getService()
        }
    }

}