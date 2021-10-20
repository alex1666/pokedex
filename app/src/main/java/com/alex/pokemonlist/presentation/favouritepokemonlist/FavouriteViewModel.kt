package com.alex.pokemonlist.presentation.favouritepokemonlist

import androidx.lifecycle.LiveData
import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.domain.interactor.PokemonInteractor
import com.alex.pokemonlist.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel
@Inject
constructor(private val pokemonInteractor: PokemonInteractor) :
    BaseViewModel() {

    fun getFavourite(): LiveData<List<Pokemon>> {
        return pokemonInteractor.getFavourite()
    }

}