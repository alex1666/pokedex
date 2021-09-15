package com.alex.pokemonlist.presentation.viewmodel

import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.domain.usecase.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel
@Inject
constructor(private val pokemonUseCase: PokemonUseCase) :
    BaseViewModel() {

    fun getFavourite(): List<Pokemon> {
        return pokemonUseCase.getFavourite()
    }

}