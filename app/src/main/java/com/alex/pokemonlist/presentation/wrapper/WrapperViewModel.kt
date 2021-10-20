package com.alex.pokemonlist.presentation.wrapper

import android.util.Log
import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.domain.interactor.PokemonInteractor
import com.alex.pokemonlist.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class WrapperViewModel
@Inject
constructor(private val pokemonInteractor: PokemonInteractor) :
    BaseViewModel() {

    fun refreshData() {
      getListPokemon()
    }

    private fun addDao(Pokemon: List<Pokemon>) {
        pokemonInteractor.add(Pokemon)

    }

    private fun getListPokemon() {
        pokemonInteractor.getPokemon()
            .subscribeOn(Schedulers.io())
            .subscribe({
                if(pokemonInteractor.getPokemon().blockingGet().isEmpty())
                addDao(it)
                },
                { error ->
                    Log.e(error::class.simpleName, error.message.toString())
                })
            .untilCleared()
    }

}