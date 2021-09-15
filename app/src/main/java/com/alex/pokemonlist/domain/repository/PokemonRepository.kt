package com.alex.pokemonlist.domain.repository

import com.alex.pokemonlist.domain.model.Pokemon
import io.reactivex.Single

interface PokemonRepository {
    fun getPokemon(): Single<List<Pokemon>>
    fun all(): List<Pokemon>
    fun add(pokemon: List<Pokemon>)
    fun getById(id: String): List<Pokemon>
    fun getByIds(evolutionIds: List<String>): List<Pokemon>
    fun getByName(name: String): List<Pokemon>
    fun getFavourite(): List<Pokemon>
    fun addFavourite(name: String, favourite: Boolean)

}