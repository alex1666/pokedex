package com.alex.pokemonlist.presentation.viewmodel


import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.domain.usecase.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class SearchViewModel
@Inject
constructor(private val pokemonUseCase: PokemonUseCase) :
    BaseViewModel() {

    fun getPokemonById(id: String): List<Pokemon> {
        return pokemonUseCase.getById(id)
    }
    fun getPokemonByName(name: String): List<Pokemon> {
        return pokemonUseCase.getByName(name)
    }
    fun getEvolution(id: List<String>): List<Pokemon> {
        return pokemonUseCase.getByIds(id)
    }
    fun addFavourite(name: String){
        return pokemonUseCase.addFavourite(name,true)
    }
}

