package com.alex.pokemonlist.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.domain.usecase.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject
constructor(private val pokemonUseCase: PokemonUseCase) :
    BaseViewModel() {
    private val listPokemon = MutableLiveData<List<Pokemon>>()

    fun getPokemonModel(): LiveData<List<Pokemon>> = listPokemon

    fun refreshData() {
        getListPokemon()
    }

    private fun getListPokemon() {
        pokemonUseCase.pokemonUseCase()
            .subscribeOn(Schedulers.io())
            .subscribe({ listPokemon.postValue(it) },
                { error ->
                    Log.e(error::class.simpleName, error.message.toString())
                })
            .untilCleared()
    }


}