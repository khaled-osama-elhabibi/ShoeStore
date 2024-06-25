package com.udacity.shoestore

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

        val email = readFromSharedPreferences(this, "email")
        val password = readFromSharedPreferences(this, "password")

        Log.i("EMAIL ==>",email.toString())
        Log.i("PASSWORD ==>",password.toString())

        val navController = findNavController(R.id.nav_host_fragment)
        if (email !== null && password !== null) {
            val navOptions = NavOptions.Builder()
                .setPopUpTo(navController.graph.startDestinationId, inclusive = true)
                .build()
            navController.navigate(R.id.listingFragment, null, navOptions)
        }
    }
    private fun readFromSharedPreferences(context: Context, key: String): String? {
        val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        return sharedPreferences.getString(key, null)
    }
}
