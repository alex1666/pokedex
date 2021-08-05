package com.alex.pokemonlist.domain.repository

import com.alex.pokemonlist.domain.model.Poke
import com.alex.pokemonlist.domain.model.Pokemon
import io.reactivex.Single

interface PokemonRepository {
    fun getPokemon(): Single<Poke>
    fun addPokemon(pokedex:List<Pokemon>)
    fun allPokemon(): List<Pokemon>
}