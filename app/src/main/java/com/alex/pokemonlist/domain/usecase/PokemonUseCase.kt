package com.alex.pokemonlist.domain.usecase


import androidx.lifecycle.LiveData
import com.alex.pokemonlist.domain.model.Pokemon
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

interface PokemonUseCase {
    fun pokemonUseCase(): Single<List<Pokemon>>
    fun all(): LiveData<List<Pokemon>>
    fun add(pokemon: List<Pokemon>)
    fun getById(id: String):LiveData<List<Pokemon>>
    fun getByIds(Ids: List<String>): LiveData<List<Pokemon>>
    fun getByName(name: String):LiveData<List<Pokemon>>
    fun addFavourite(name: String, favourite: Boolean)
    fun getFavourite(): LiveData<List<Pokemon>>
    fun checkFavourite(name: String, favourite: Boolean):LiveData<List<Pokemon>>
}