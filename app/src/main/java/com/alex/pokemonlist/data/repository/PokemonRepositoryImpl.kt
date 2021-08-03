package com.alex.pokemonlist.data.repository

import com.alex.pokemonlist.data.source.remote.RetrofitService
import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.domain.repository.PokemonRepository
import io.reactivex.Single
import javax.inject.Inject

class PokemonRepositoryImpl
@Inject
constructor(private val retrofitService: RetrofitService) :
    PokemonRepository {
    override fun getPokemon(pokemonName: String): Single<List<Pokemon>> {
        return retrofitService.getPokemon(pokemonName)
    }
}