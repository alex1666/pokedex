package com.alex.pokemonlist.domain.usecase


import com.alex.pokemonlist.domain.model.Poke
import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.domain.repository.PokemonRepository
import io.reactivex.Single
import javax.inject.Inject

class PokemonUseCaseImpl
@Inject
constructor(private val repository: PokemonRepository) :
    PokemonUseCase {
    override fun pokemonUseCase(): Single<Poke> {
        return repository.getPokemon()
    }

    override fun addPokemon(pokedex:List<Pokemon>) {
        return repository.addPokemon(pokedex)
    }

    override fun allPokemon(): List<Pokemon> {
        return repository.allPokemon()
    }

}