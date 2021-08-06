package com.alex.pokemonlist.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alex.pokemonlist.data.source.local.dao.PokedexDAO
import com.alex.pokemonlist.domain.model.Poke
import com.alex.pokemonlist.domain.model.Pokedex
import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.domain.usecase.PokedexUseCase
import com.alex.pokemonlist.domain.usecase.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class PokedexViewModel @Inject
constructor(private val pokemonUseCase: PokemonUseCase) :
    BaseViewModel() {
    private val pokedex = MutableLiveData<Poke>()

    fun getPokedexModel(): LiveData<Poke> = pokedex

    fun refreshData() {
        getPokedex()
    }

    fun addPokedex(pokedex: Poke) {
        pokemonUseCase.addPokemon(pokedex.pokemon)

    }

    fun getPokedexDao(): List<Pokemon> {
        return pokemonUseCase.allPokemon()
    }
    private fun getPokedex() {
        pokemonUseCase.pokemonUseCase()
            .subscribeOn(Schedulers.io())
            .subscribe({ it },
                { error ->
                    Log.e(error::class.simpleName, error.message.toString())
                })
            .untilCleared()
    }


}