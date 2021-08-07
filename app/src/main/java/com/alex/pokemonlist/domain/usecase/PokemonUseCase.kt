package com.alex.pokemonlist.domain.usecase


import com.alex.pokemonlist.domain.model.Pokemon
import io.reactivex.Single

interface PokemonUseCase {
    fun pokemonUseCase(): Single<List<Pokemon>>
}