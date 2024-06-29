package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ListingViewModel: ViewModel() {
    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList : LiveData<MutableList<Shoe>>
    get() = _shoeList

    private var _newShoe = MutableLiveData<Shoe>()
    val newShoe : LiveData<Shoe>
        get() = _newShoe

    init {
        _newShoe.value = Shoe("",0.0,"","")
        _shoeList.value = mutableListOf(
            Shoe("Original 00",48.00,"Zara","One of the best in the world"),
            Shoe("Original 01",39.00,"Nike","One of the best in the world"),
            Shoe("Original 03",45.00,"Addis","One of the best in the world"),
            Shoe("THe Best",43.00,"O & M","One of the best in the world"),
            Shoe("Original",45.00,"Zara","One of the best in the world"),
            Shoe("Original",41.00,"Zara","One of the best in the world"),
        )
    }
    fun addShoe() {
        _shoeList.value?.let {
            val updatedList = it.toMutableList()
            updatedList.add(newShoe.value!!)
            _shoeList.value = updatedList
        }
        _newShoe.value = Shoe("",0.0,"","")

    }

}