package com.alex.pokemonlist.data.source.remote

import com.alex.pokemonlist.domain.model.Pokemon
import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitService {

    @GET("pokemon.json")
    fun getPokemon(): Single<List<Pokemon>>


}