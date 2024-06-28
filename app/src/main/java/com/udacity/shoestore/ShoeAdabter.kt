package com.udacity.shoestore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.databinding.ShowItemBinding
import com.udacity.shoestore.models.Shoe

class ShoeAdapter(private val shoeList: MutableList<Shoe>, private val navController: NavController) : RecyclerView.Adapter<ShoeAdapter.ShoeViewHolder>() {

    class ShoeViewHolder(val binding: ShowItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val binding: ShowItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.show_item, parent, false
        )
        return ShoeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        val shoe = shoeList[position]
        holder.binding.shoe = shoe
        holder.binding.goToButton.setOnClickListener {
            val action = ListingFragmentDirections.actionListingFragmentToDetailsFragment(shoe.name,shoe.size.toString(),shoe.company,shoe.description)
            navController.navigate(action)
        }
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return shoeList.size
    }
}