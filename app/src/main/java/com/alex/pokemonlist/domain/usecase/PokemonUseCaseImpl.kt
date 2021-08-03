package com.alex.pokemonlist.domain.usecase


import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.domain.repository.PokemonRepository
import io.reactivex.Single
import javax.inject.Inject

class PokemonUseCaseImpl
@Inject
constructor(private val repository: PokemonRepository) :
    PokemonUseCase {
    override fun pokemonUseCase(pokemonName: String): Single<List<Pokemon>> {
        return repository.getPokemon(pokemonName)
    }
}