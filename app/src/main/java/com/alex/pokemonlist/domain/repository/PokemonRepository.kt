package com.alex.pokemonlist.domain.repository

import com.alex.pokemonlist.domain.model.Pokemon
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    fun getPokemon(): Single<List<Pokemon>>
    fun all(): Flow<List<Pokemon>>
    fun add(pokemon: List<Pokemon>)
    fun getById(id: String): Flow<List<Pokemon>>
    fun getByIds(evolutionIds: List<String>): Flow<List<Pokemon>>
    fun getByName(name: String): Flow<List<Pokemon>>
    fun getFavourite(): Flow<List<Pokemon>>
    fun addFavourite(name: String, favourite: Boolean)
}