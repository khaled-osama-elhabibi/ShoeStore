package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class DetailsViewModel: ViewModel() {
    private var _shoe = MutableLiveData<Shoe>()
    val shoe : LiveData<Shoe>
    get() = _shoe
    init {
        _shoe.value = Shoe("Original 00",48.00,"Zara","One of the best in the world")
    }
}