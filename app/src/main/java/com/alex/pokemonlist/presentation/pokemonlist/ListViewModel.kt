package com.alex.pokemonlist.presentation.pokemonlist

import androidx.lifecycle.LiveData
import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.domain.interactor.PokemonInteractor
import com.alex.pokemonlist.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject
constructor(private val pokemonInteractor: PokemonInteractor) :
    BaseViewModel() {

    fun allPokemon(): LiveData<List<Pokemon>> {
        return pokemonInteractor.all()
    }

}