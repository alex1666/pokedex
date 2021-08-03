package com.alex.pokemonlist.data.source.remote



import com.alex.pokemonlist.domain.model.Pokemon
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {

    //https://pokeapi.co/api/v2/pokemon/1/

    @GET("{id}")
    fun getPokemon(
        @Path("id") id: String,
    ): Single<List<Pokemon>>

}