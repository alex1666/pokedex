package com.alex.pokemonlist.presentation.view

import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import com.alex.pokemonlist.R
import com.alex.pokemonlist.presentation.viewmodel.PokemonViewModel
import com.alex.pokemonlist.util.Constants.wallpaperTime
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : FragmentActivity() {
    val viewModel: PokemonViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({
            supportFragmentManager
                .beginTransaction()
                .apply {
                    replace(R.id.container, MenuFragment())
                    commit()
                }
        },  wallpaperTime.toLong())
    }
    override fun onBackPressed()
    {
        super.onBackPressed()
    }
}

