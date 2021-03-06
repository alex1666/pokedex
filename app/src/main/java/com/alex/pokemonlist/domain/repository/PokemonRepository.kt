package com.alex.pokemonlist.domain.repository

import androidx.lifecycle.LiveData
import com.alex.pokemonlist.domain.model.Pokemon
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    fun getPokemon(): Single<List<Pokemon>>
    fun all(): LiveData<List<Pokemon>>
    fun add(pokemon: List<Pokemon>)
    fun getById(id: String): List<Pokemon>
    fun getByIds(evolutionIds: List<String>): List<Pokemon>
    fun getByName(name: String): List<Pokemon>
    fun getFavourite(): LiveData<List<Pokemon>>
    fun addFavourite(name: String, favourite: Boolean)
}