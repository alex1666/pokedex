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
class PokemonViewModel
@Inject
constructor(private val pokemonUseCase: PokemonUseCase) : BaseViewModel() {

    private val pokemon = MutableLiveData<List<Pokemon>>()

    fun getPokemonModel(): LiveData<List<Pokemon>> = pokemon

    fun refreshData(pokemonName: String) {
        getPokemon(pokemonName)
    }
    private fun getPokemon(pokemonName: String) {
        pokemonUseCase.pokemonUseCase(pokemonName)
            .subscribeOn(Schedulers.io())
            .subscribe({ pokemon.postValue(it) },
                { error ->
                    Log.e(error::class.simpleName, error.message.toString())
                })
            .untilCleared()

    }

}

