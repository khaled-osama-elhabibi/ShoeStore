package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.databinding.FragmentInstructionBinding
import com.udacity.shoestore.databinding.FragmentOnboardingBinding

class InstructionFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentInstructionBinding>(inflater,R.layout.fragment_instruction,container,false)
        binding.continueFromInstructionButton.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(InstructionFragmentDirections.actionInstructionFragmentToListingFragment())

        }
        return binding.root
    }
}