package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.databinding.FragmentLoginBinding
import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class LoginFragment : Fragment() {
    private lateinit var loginViewModel :LoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater,R.layout.fragment_login,container, false)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.viewModel = loginViewModel
        binding.lifecycleOwner = this

        binding.logInButton.setOnClickListener {
            login()
        }
        return binding.root
    }

    private fun login() {
        val sharedPreferences = context?.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences!!.edit()
        editor.putString("email", loginViewModel.credential.value!!.email)
        editor.putString("password", loginViewModel.credential.value!!.password)
        editor.apply()
        val action = LoginFragmentDirections.actionLoginFragmentToOnBoardingFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }

}