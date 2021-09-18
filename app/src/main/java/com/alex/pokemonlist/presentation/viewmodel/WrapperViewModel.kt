package com.alex.pokemonlist.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.domain.usecase.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WrapperViewModel
@Inject
constructor(private val pokemonUseCase: PokemonUseCase) :
    BaseViewModel() {

    fun refreshData() {
        viewModelScope.launch(Dispatchers.IO) { getListPokemon() }
    }

    private fun addDao(Pokemon: List<Pokemon>) {
        pokemonUseCase.add(Pokemon)

    }

    private fun getListPokemon() {
        pokemonUseCase.pokemonUseCase()
            .subscribeOn(Schedulers.io())
            .subscribe({
                viewModelScope.launch(Dispatchers.IO) {
                    pokemonUseCase.all()
                        .collect { value: List<Pokemon> -> if (value.isEmpty()) addDao(it) }
                }
            },
                { error ->
                    Log.e(error::class.simpleName, error.message.toString())
                })
            .untilCleared()
    }


}