package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Credential

class LoginViewModel: ViewModel() {
    private val _credential = MutableLiveData<Credential>()
    val credential : LiveData<Credential>
        get() = _credential
   init {
       _credential.value = Credential("","")
   }

}