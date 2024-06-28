package com.udacity.shoestore

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener

@BindingAdapter("android:text")
fun setDouble(editText: EditText, value: Double) {
    if (editText.text.toString() != value.toString()) {
        editText.setText(value.toString())
    }
}

@InverseBindingAdapter(attribute = "android:text")
fun getDouble(editText: EditText): Double {
    return try {
        editText.text.toString().toDouble()
    } catch (e: NumberFormatException) {
        0.0
    }
}

@BindingAdapter("android:textAttrChanged")
fun setDoubleListener(editText: EditText, listener: InverseBindingListener) {
    editText.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            listener.onChange()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    })
}