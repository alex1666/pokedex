package com.alex.pokemonlist.domain.repository

import com.alex.pokemonlist.domain.model.Pokemon
import io.reactivex.Single

interface PokemonRepository {
    fun getPokemon(pokemonName: String): Single<List<Pokemon>>
}