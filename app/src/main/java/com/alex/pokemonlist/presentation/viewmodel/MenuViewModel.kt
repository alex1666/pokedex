package com.alex.pokemonlist.presentation.viewmodel

import android.view.View
import androidx.navigation.findNavController
import com.alex.pokemonlist.R
import com.alex.pokemonlist.domain.usecase.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject
constructor(private val pokemonUseCase: PokemonUseCase) :
    BaseViewModel() {
}

