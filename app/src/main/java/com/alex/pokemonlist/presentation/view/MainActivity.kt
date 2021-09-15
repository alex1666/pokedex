package com.alex.pokemonlist.presentation.view

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.alex.pokemonlist.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : FragmentActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNav()
    }

    private fun initNav() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }
}

