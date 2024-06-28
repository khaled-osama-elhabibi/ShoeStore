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
    init {
        _shoeList.value = mutableListOf(
            Shoe("Original 00",48.00,"Zara","One of the best in the world"),
            Shoe("Original 01",39.00,"Nike","One of the best in the world"),
            Shoe("Original 03",45.00,"Addis","One of the best in the world"),
            Shoe("THe Best",43.00,"O & M","One of the best in the world"),
            Shoe("Original",45.00,"Zara","One of the best in the world"),
            Shoe("Original",41.00,"Zara","One of the best in the world"),
        )
    }
    fun addShoe(shoe: Shoe) {
        _shoeList.value?.let {
            val updatedList = it.toMutableList()
            updatedList.add(shoe)
            _shoeList.value = updatedList
        }
    }


    override fun onCleared() {
        super.onCleared()
    }
}