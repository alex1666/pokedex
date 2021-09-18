package com.alex.pokemonlist.presentation.viewmodel


import androidx.lifecycle.viewModelScope
import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.domain.usecase.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
open class SearchViewModel
@Inject
constructor(private val pokemonUseCase: PokemonUseCase) :
    BaseViewModel() {

    suspend fun getPokemonById(id: String): Flow<List<Pokemon>> {
        return withContext(Dispatchers.IO) {pokemonUseCase.getById(id)}
    }

    suspend fun getPokemonByName(name: String): Flow<List<Pokemon>> {
        return withContext(Dispatchers.IO) {pokemonUseCase.getByName(name)}
    }

    fun getEvolution(id: List<String>): Flow<List<Pokemon>> {
        return pokemonUseCase.getByIds(id)
    }

    fun checkFavourite(name: String, favourite: Boolean): Flow<List<Pokemon>> {
        return pokemonUseCase.checkFavourite(name, favourite)
    }

    fun addFavourite(name: String) {
        viewModelScope.launch(Dispatchers.Default) {
//            pokemonUseCase.checkFavourite(name,true).collect { value: List<Pokemon> ->
//                if (value.isEmpty())
//                    pokemonUseCase.addFavourite(name, true)
//            }
            pokemonUseCase.addFavourite(name, true)
        }

    }
}

