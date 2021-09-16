package com.alex.pokemonlist.presentation.viewmodel

import android.util.Log
import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.domain.usecase.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class WrapperViewModel
@Inject
constructor(private val pokemonUseCase: PokemonUseCase) :
    BaseViewModel() {

    fun refreshData() {
        getListPokemon()
    }

    private fun addDao(Pokemon: List<Pokemon>) {
        pokemonUseCase.add(Pokemon)
    }

    private fun getListPokemon() {
        pokemonUseCase.pokemonUseCase()
            .subscribeOn(Schedulers.io())
            .subscribe({ if(pokemonUseCase.all().isEmpty())
                addDao(it) },
                { error ->
                    Log.e(error::class.simpleName, error.message.toString())
                })
            .untilCleared()
    }


}