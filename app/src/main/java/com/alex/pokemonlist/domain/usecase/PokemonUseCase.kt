package com.alex.pokemonlist.domain.usecase


import com.alex.pokemonlist.domain.model.Favourite
import com.alex.pokemonlist.domain.model.Pokemon
import io.reactivex.Single

interface PokemonUseCase {
    fun pokemonUseCase(): Single<List<Pokemon>>
    fun all(): List<Pokemon>
    fun add(pokemon: List<Pokemon>)
    fun getById(id: String): List<Pokemon>
    fun getByIds(Ids: List<String>): List<Pokemon>
    fun getByName(name: String): List<Pokemon>
    fun allFavourite(): List<Favourite>
    fun addFavourite(favourite: Favourite)
}