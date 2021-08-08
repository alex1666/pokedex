package com.alex.pokemonlist.domain.usecase


import com.alex.pokemonlist.domain.model.Pokedex
import io.reactivex.Single

interface PokedexUseCase {
    fun pokedexUseCase(pokemonName: String): Single<List<Pokedex>>

    fun addPokedex(pokedex: List<Pokedex>)

    fun allPokedex(): List<Pokedex>
}