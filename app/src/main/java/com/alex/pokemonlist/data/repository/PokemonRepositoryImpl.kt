package com.alex.pokemonlist.data.repository

import com.alex.pokemonlist.data.source.local.PokemonDatabase
import com.alex.pokemonlist.data.source.remote.RetrofitService
import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.domain.repository.PokemonRepository
import io.reactivex.Single
import javax.inject.Inject

class PokemonRepositoryImpl
@Inject
constructor(
    private val database: PokemonDatabase,
    private val retrofitService: RetrofitService,
) :
    PokemonRepository {
    override fun getPokemon(): Single<List<Pokemon>> {
        return retrofitService.getPokemon()
    }

    override fun all(): List<Pokemon> {
        return database.pokemonDAO().all()
    }

    override fun add(pokemon: List<Pokemon>) {
        return database.pokemonDAO().add(pokemon)
    }

    override fun getById(id: String): List<Pokemon> {
        return database.pokemonDAO().getById(id)
    }

    override fun getByIds(Ids: List<String>): List<Pokemon> {
        return database.pokemonDAO().getByIds(Ids)
    }

    override fun getFavourite(): List<Pokemon> {
        return database.pokemonDAO().getFavourite()
    }

    override fun addFavourite(name: String, favourite: Boolean) {
        return database.pokemonDAO().addFavourite(name, favourite)
    }

    override fun getByName(name: String): List<Pokemon> {
        return database.pokemonDAO().getByName(name)
    }
}