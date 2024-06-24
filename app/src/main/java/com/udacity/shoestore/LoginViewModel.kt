package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    private val _email = MutableLiveData<String>()
    val email : LiveData<String>
        get() = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String>
        get() = _password

   init {
       _email.value = "khaled@osama"
       _password.value = "222222"
   }

    fun changePassword(text: String) {
        Log.i("changePassword",text)
        _password.value = text

    }
    fun changeEmail(text: String) {
        Log.i("changeEmail",text)
        _email.value = text
    }

}