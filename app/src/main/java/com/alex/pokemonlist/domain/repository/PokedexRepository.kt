package com.alex.pokemonlist.domain.repository

import com.alex.pokemonlist.domain.model.Pokedex
import io.reactivex.Single

interface PokedexRepository {
    fun getPokedex(pokemonName: String): Single<List<Pokedex>>
    fun addPokedex(pokedex: List<Pokedex>)
    fun allPokedex(): List<Pokedex>
}