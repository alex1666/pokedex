package com.alex.pokemonlist.data.repository

import com.alex.pokemonlist.data.source.local.PokemonDatabase
import com.alex.pokemonlist.data.source.remote.RetrofitService
import com.alex.pokemonlist.domain.model.Poke
import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.domain.repository.PokemonRepository
import io.reactivex.Single
import javax.inject.Inject

class PokemonRepositoryImpl
@Inject
constructor(private val database: PokemonDatabase, private val retrofitService: RetrofitService) :
    PokemonRepository {
    override fun getPokemon(): Single<Poke> {
        return retrofitService.getPokemon()
    }

    override fun addPokemon(pokedex:List<Pokemon>){
        database.pokemonDAO().add(pokedex)
    }

    override fun allPokemon(): List<Pokemon> {
        return database.pokemonDAO().all()
    }
}