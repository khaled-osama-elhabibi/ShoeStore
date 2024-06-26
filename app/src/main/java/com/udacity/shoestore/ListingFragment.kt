package com.udacity.shoestore

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.udacity.shoestore.databinding.FragmentListingBinding

class ListingFragment: Fragment() {
    private val listingViewModel: ListingViewModel by activityViewModels()
    private lateinit var listingBinding :FragmentListingBinding
    private lateinit var navController :NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        navController = NavHostFragment.findNavController(this)
        listingBinding = DataBindingUtil.inflate<FragmentListingBinding>(inflater,R.layout.fragment_listing,container,false)
        val menuHost: MenuHost = requireActivity()
        listingBinding.shoeItemsRecycleView.layoutManager = LinearLayoutManager(context)
        listingBinding.shoeItemsRecycleView.adapter = ShoeAdapter(listingViewModel.shoeList.value!!)
        listingBinding.goToButton.setOnClickListener {
            val action = ListingFragmentDirections.actionListingFragmentToDetailsFragment()
            navController.navigate(action)
        }

        menuHost.addMenuProvider(object: MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.logout, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.logoutButton -> {
                        logOut()
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return listingBinding.root
    }

    private fun logOut () {
        val sharedPreferences = context?.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences!!.edit()
        editor.remove("email")
        editor.remove("password")
        editor.apply()
        navController.navigate(ListingFragmentDirections.actionListingFragmentToLoginFragment())
    }
}