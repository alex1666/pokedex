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

    fun allPokemon():List<Pokemon>{
        return pokemonUseCase.all()
    }

}