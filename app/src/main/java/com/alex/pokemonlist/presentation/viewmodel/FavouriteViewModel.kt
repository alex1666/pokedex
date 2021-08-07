package com.alex.pokemonlist.presentation.viewmodel

import com.alex.pokemonlist.domain.model.Pokedex
import com.alex.pokemonlist.domain.usecase.PokedexUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel
@Inject
constructor(private val pokedexUseCase: PokedexUseCase) :
    BaseViewModel() {

    fun getListPokemon(): List<Pokedex> {
        return pokedexUseCase.allPokedex()
    }

}