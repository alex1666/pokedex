package com.alex.pokemonlist.presentation.viewmodel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alex.pokemonlist.domain.model.Pokedex
import com.alex.pokemonlist.domain.usecase.PokedexUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
open class SearchViewModel
@Inject
constructor(private val pokedexUseCase: PokedexUseCase) :
    BaseViewModel() {
    private val pokedex = MutableLiveData<List<Pokedex>>()
    fun getPokedexModel(): LiveData<List<Pokedex>> = pokedex
    fun refreshData(pokemonName: String) {
        getPokemon(pokemonName)
    }

    fun addPokedex(pokedex: List<Pokedex>) {
        pokedexUseCase.addPokedex(pokedex)

    }

    private fun getPokemon(pokemonName: String) {
        pokedexUseCase.pokedexUseCase(pokemonName)
            .subscribeOn(Schedulers.io())
            .subscribe({ pokedex.postValue(it) },
                { error ->
                    Log.e(error::class.simpleName, error.message.toString())
                })
            .untilCleared()
    }
}

