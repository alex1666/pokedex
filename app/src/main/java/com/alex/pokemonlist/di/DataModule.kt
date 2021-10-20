package com.alex.pokemonlist.di

import com.alex.pokemonlist.data.repository.PokemonRepositoryImpl
import com.alex.pokemonlist.data.source.local.PokemonDatabase
import com.alex.pokemonlist.data.source.remote.PokemonApi
import com.alex.pokemonlist.domain.interactor.PokemonInteractor
import com.alex.pokemonlist.domain.interactor.PokemonInteractorImpl
import com.alex.pokemonlist.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Singleton
    @Provides
    fun providePokemonRepository(
        database: PokemonDatabase,
        pokemonApi: PokemonApi,
    ): PokemonRepository {
        return PokemonRepositoryImpl(database, pokemonApi)
    }

    @Singleton
    @Provides
    fun providePokemonInteractor(pokemonRepository: PokemonRepository): PokemonInteractor {
        return PokemonInteractorImpl(pokemonRepository)
    }
}