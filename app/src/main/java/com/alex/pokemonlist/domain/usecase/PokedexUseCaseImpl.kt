package com.alex.pokemonlist.domain.usecase


import com.alex.pokemonlist.domain.model.Pokedex
import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.domain.repository.PokedexRepository
import com.alex.pokemonlist.domain.repository.PokemonRepository
import io.reactivex.Single
import javax.inject.Inject

class PokedexUseCaseImpl
@Inject
constructor(private val repository: PokedexRepository) :
    PokedexUseCase {
    override fun pokedexUseCase(pokemonName:String): Single<List<Pokedex>>{
        return repository.getPokedex(pokemonName)
    }

    override fun addPokedex( pokedex:List<Pokedex>) {
        return repository.addPokedex(pokedex)
    }

    override fun allPokedex(): List<Pokedex>{
        return repository.allPokedex()
    }

}