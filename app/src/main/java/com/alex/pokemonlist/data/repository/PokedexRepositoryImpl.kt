package com.alex.pokemonlist.data.repository

import com.alex.pokemonlist.data.source.local.PokedexDatabase
import com.alex.pokemonlist.data.source.remote.RetrofitService
import com.alex.pokemonlist.domain.model.Pokedex
import com.alex.pokemonlist.domain.repository.PokedexRepository
import io.reactivex.Single
import javax.inject.Inject

class PokedexRepositoryImpl
@Inject
constructor(private val database: PokedexDatabase, private val retrofitService: RetrofitService) :
    PokedexRepository {

    override fun getPokedex(pokemonName:String): Single<List<Pokedex>> {
        return retrofitService.getPokedex(pokemonName)
    }

    override fun addPokedex(pokedex:List<Pokedex>) {
        database.pokedexDAO().add(pokedex)
    }

    override fun allPokedex(): List<Pokedex> {
        return database.pokedexDAO().all()
    }
}