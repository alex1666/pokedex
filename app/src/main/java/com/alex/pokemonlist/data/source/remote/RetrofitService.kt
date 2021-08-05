package com.alex.pokemonlist.data.source.remote


import com.alex.pokemonlist.domain.model.Poke
import com.alex.pokemonlist.domain.model.Pokedex
import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.util.Constants.urlPokedex
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    //https://pokeapi.co/api/v2/pokemon/1/

    @GET("{id}")
    fun getPokedex(
        @Path("id") id: String,
    ): Single<List<Pokedex>>

    @GET(urlPokedex)
    fun getPokemon(): Single<Poke>


}