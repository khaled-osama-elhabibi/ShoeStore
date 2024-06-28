package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.models.Shoe

class DetailsFragment: Fragment() {
    private lateinit var navController : NavController
    private val detailsViewModel : ListingViewModel by activityViewModels()
    private lateinit var binding : FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        detailsViewModel = ViewModelProvider(this).get(ListingViewModel::class.java)
        navController = NavHostFragment.findNavController(this)
        binding = DataBindingUtil.inflate<FragmentDetailsBinding>(
            inflater,
            R.layout.fragment_details,
            container,false)

        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object: MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {}

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    android.R.id.home -> {
                        onBackPressed()
                        return true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)


        binding.cancelButton.setOnClickListener {
            navController.navigateUp()
        }

        binding.saveButton.setOnClickListener {
            saveNewShoeItem()
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onPause() {
        super.onPause()
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }
    private fun onBackPressed(){
        navController.navigateUp()
    }
    private fun saveNewShoeItem(){
        binding.apply {
            val newShoe = Shoe(
                shoeNameInput.text.toString(),
                shoeSizeInput.text.toString().toDouble(),
                shoeDescriptionTextView.text.toString(),
                companyInputEditText.text.toString(),
            )
            detailsViewModel.addShoe(newShoe)
            val action = DetailsFragmentDirections.actionDetailsFragmentToListingFragment()
            navController.navigate(action)
        }
    }

}