package com.alex.pokemonlist.presentation.pokemonsearch

import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.domain.interactor.PokemonInteractor
import com.alex.pokemonlist.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
open class SearchViewModel
@Inject
constructor(private val pokemonInteractor: PokemonInteractor) :
    BaseViewModel() {

    suspend fun getPokemonById(id: String): List<Pokemon> {
        return withContext(Dispatchers.IO){pokemonInteractor.getById(id)}
    }

    suspend fun getPokemonByName(name: String): List<Pokemon> {
        return withContext(Dispatchers.IO){pokemonInteractor.getByName(name)}
    }

    suspend fun getEvolution(id: List<String>): List<Pokemon> {
        return withContext(Dispatchers.IO){pokemonInteractor.getByIds(id)}
    }

    suspend fun addFavourite(name: String) {
        withContext(Dispatchers.IO){
            pokemonInteractor.addFavourite(name, true)
        }
    }

}


