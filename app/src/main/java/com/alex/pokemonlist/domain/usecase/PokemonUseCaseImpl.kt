package com.alex.pokemonlist.domain.usecase


import androidx.lifecycle.LiveData
import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.domain.repository.PokemonRepository
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonUseCaseImpl
@Inject
constructor(private val repository: PokemonRepository) :
    PokemonUseCase {
    override fun pokemonUseCase(): Single<List<Pokemon>> {
        return repository.getPokemon()
    }

    override fun all(): LiveData<List<Pokemon>> {
        return repository.all()
    }

    override fun add(pokemon: List<Pokemon>) {
        return repository.add(pokemon)
    }

    override fun getById(id: String): LiveData<List<Pokemon>> {
        return repository.getById(id)
    }

    override fun getByIds(Ids: List<String>): LiveData<List<Pokemon>> {
        return repository.getByIds(Ids)
    }

    override fun getByName(name: String): LiveData<List<Pokemon>>{
        return repository.getByName(name)
    }

    override fun getFavourite():LiveData<List<Pokemon>> {
        return repository.getFavourite()
    }

    override fun addFavourite(name: String, favourite: Boolean) {
        return repository.addFavourite(name, favourite)
    }
    override fun checkFavourite(name: String, favourite: Boolean):LiveData<List<Pokemon>>{
        return repository.checkFavourite(name,favourite)
    }

}