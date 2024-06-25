package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentOnboardingBinding

class OnBoardingFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentOnboardingBinding>(inflater,R.layout.fragment_onboarding,container,false)
        binding.continueFromOnBoardingButton.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(OnBoardingFragmentDirections.actionOnBoardingFragmentToInstructionFragment())
        }

        return binding.root
    }
}