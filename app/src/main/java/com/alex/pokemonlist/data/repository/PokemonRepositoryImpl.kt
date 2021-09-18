package com.alex.pokemonlist.data.repository

import com.alex.pokemonlist.data.source.local.PokemonDatabase
import com.alex.pokemonlist.data.source.remote.RetrofitService
import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.domain.repository.PokemonRepository
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow
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

    override fun all(): Flow<List<Pokemon>> {
        return database.pokemonDAO().all()
    }

    override fun add(pokemon: List<Pokemon>) {
        database.pokemonDAO().add(pokemon)
    }

    override fun getById(id: String): Flow<List<Pokemon>> {
        return database.pokemonDAO().getById(id)
    }

    override fun getByIds(evolutionIds: List<String>): Flow<List<Pokemon>> {
        return database.pokemonDAO().getByIds(evolutionIds)
    }

    override fun getFavourite(): Flow<List<Pokemon>> {
        return database.pokemonDAO().getFavourite()
    }

    override fun addFavourite(name: String, favourite: Boolean) {
        database.pokemonDAO().addFavourite(name, favourite)

    }

    override fun getByName(name: String): Flow<List<Pokemon>> {
        return database.pokemonDAO().getByName(name)
    }
}