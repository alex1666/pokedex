package com.alex.pokemonlist.domain.interactor

import androidx.lifecycle.LiveData
import com.alex.pokemonlist.domain.model.Pokemon
import io.reactivex.Single

interface PokemonInteractor {
    fun getPokemon(): Single<List<Pokemon>>
    fun all(): LiveData<List<Pokemon>>
    fun add(pokemon: List<Pokemon>)
    fun getById(id: String): List<Pokemon>
    fun getByIds(Ids: List<String>):List<Pokemon>
    fun getByName(name: String): List<Pokemon>
    fun addFavourite(name: String, favourite: Boolean)
    fun getFavourite(): LiveData<List<Pokemon>>
}