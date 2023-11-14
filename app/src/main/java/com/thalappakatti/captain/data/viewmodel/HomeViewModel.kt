/*
 * Created by Nethaji V on 31/01/22, 3:19 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 3:19 PM
 */

package com.thalappakatti.captain.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}