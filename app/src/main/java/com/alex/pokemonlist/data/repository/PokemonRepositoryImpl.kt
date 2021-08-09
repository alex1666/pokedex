package com.alex.pokemonlist.data.repository

import com.alex.pokemonlist.data.source.local.FavouriteDatabase
import com.alex.pokemonlist.data.source.local.PokemonDatabase
import com.alex.pokemonlist.data.source.remote.RetrofitService
import com.alex.pokemonlist.domain.model.Favourite
import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.domain.repository.PokemonRepository
import io.reactivex.Single
import javax.inject.Inject

class PokemonRepositoryImpl
@Inject
constructor(
    private val database: PokemonDatabase,
    private val favouriteDatabase: FavouriteDatabase,
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

    override fun getByName(name: String): List<Pokemon> {
        return database.pokemonDAO().getByName(name)
    }

    override fun allFavourite(): List<Favourite> {
        return favouriteDatabase.favouriteDao().all()
    }

    override fun addFavourite(favourite: Favourite) {
        return favouriteDatabase.favouriteDao().add(favourite)
    }

}