package com.alex.pokemonlist.domain.usecase


import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.domain.repository.PokemonRepository
import io.reactivex.Single
import javax.inject.Inject

class PokemonUseCaseImpl
@Inject
constructor(private val repository: PokemonRepository) :
    PokemonUseCase {
    override fun pokemonUseCase(): Single<List<Pokemon>> {
        return repository.getPokemon()
    }

    override fun all(): List<Pokemon> {
        return repository.all()
    }

    override fun add(pokemon: List<Pokemon>) {
        return repository.add(pokemon)
    }

    override fun getById(id: String): List<Pokemon> {
        return repository.getById(id)
    }

    override fun getByIds(Ids: List<String>): List<Pokemon> {
        return repository.getByIds(Ids)
    }

    override fun getByName(name: String): List<Pokemon> {
        return repository.getByName(name)
    }

    override fun getFavourite(): List<Pokemon> {
        return repository.getFavourite()
    }

    override fun addFavourite(name: String, favourite: Boolean) {
        return repository.addFavourite(name, favourite)
    }

}