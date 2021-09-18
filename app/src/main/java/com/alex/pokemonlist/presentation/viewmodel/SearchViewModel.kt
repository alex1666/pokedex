package com.alex.pokemonlist.presentation.viewmodel


import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.domain.usecase.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
open class SearchViewModel
@Inject
constructor(private val pokemonUseCase: PokemonUseCase) :
    BaseViewModel() {

    suspend fun getPokemonById(id: String): Flow<List<Pokemon>> {
        return withContext(Dispatchers.IO) { pokemonUseCase.getById(id) }
    }

    suspend fun getPokemonByName(name: String): Flow<List<Pokemon>> {
        return withContext(Dispatchers.IO) { pokemonUseCase.getByName(name) }
    }

    fun getEvolution(id: List<String>): Flow<List<Pokemon>> {
        return pokemonUseCase.getByIds(id)
    }

    suspend fun addFavourite(name: String) {
        withContext(Dispatchers.IO) {
            pokemonUseCase.addFavourite(name, true)
        }

    }
}


