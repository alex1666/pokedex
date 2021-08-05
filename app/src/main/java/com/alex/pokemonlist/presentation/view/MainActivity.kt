package com.alex.pokemonlist.presentation.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.alex.pokemonlist.R
import com.alex.pokemonlist.presentation.viewmodel.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : FragmentActivity() {
    lateinit var navController: NavController
    val viewModel: PokemonViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}

