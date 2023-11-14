/*
 * Created by Nethaji V on 31/01/22, 5:16 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 5:16 PM
 */

package com.thalappakatti.captain.data.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thalappakatti.captain.data.network.api.response.ResServices
import com.thalappakatti.captain.data.preference.IPreferenceManager
import com.thalappakatti.captain.data.repository.ServiceRepository
import com.thalappakatti.captain.di.OnError
import com.thalappakatti.captain.di.OnSuccess
import com.thalappakatti.captain.di.utility.Resource
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: ServiceRepository, val preference: IPreferenceManager) : ViewModel() {

    private val _responseLiveData: MutableLiveData<Resource<ResServices>> = MutableLiveData()
    val responseLiveData: LiveData<Resource<ResServices>> get() = _responseLiveData

    val navigateToLogin: MutableLiveData<Boolean> = MutableLiveData()

    val navigateToStoreSelection: MutableLiveData<Boolean> = MutableLiveData()
    val errorEmail: MutableLiveData<Int> = MutableLiveData()  //  0 -> empty, 1 -> invalid email
    val errorPassword: MutableLiveData<Int> = MutableLiveData()

    fun logout() {
        preference.clearLogin()
        navigateToLogin.value = true
    }

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

    fun performLogin(email: String, password: String) {
        if (isFieldValid(email, password)) {
            navigateToStoreSelection.postValue(true)
        }
    }

    private fun isFieldValid(email: String, password: String): Boolean {
        if (email.isEmpty()) {
            errorEmail.postValue(0)
            return false
        } else if (password.isEmpty()) {
            errorPassword.postValue(0)
            return false
        }
        return true
    }

}