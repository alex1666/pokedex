package com.alex.pokemonlist.di

import com.alex.pokemonlist.data.repository.PokedexRepositoryImpl
import com.alex.pokemonlist.data.repository.PokemonRepositoryImpl
import com.alex.pokemonlist.data.source.local.PokedexDatabase
import com.alex.pokemonlist.data.source.remote.RetrofitService
import com.alex.pokemonlist.domain.repository.PokedexRepository
import com.alex.pokemonlist.domain.repository.PokemonRepository
import com.alex.pokemonlist.domain.usecase.PokedexUseCase
import com.alex.pokemonlist.domain.usecase.PokedexUseCaseImpl
import com.alex.pokemonlist.domain.usecase.PokemonUseCase
import com.alex.pokemonlist.domain.usecase.PokemonUseCaseImpl
import com.alex.pokemonlist.util.Constants.baseUrl

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofitPokedex(
        gsonConverterFactory: GsonConverterFactory,
        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .build()
    }

    fun providesRetrofitPokemon(
        gsonConverterFactory: GsonConverterFactory,
        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun providesGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun providesGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun providesRxJavaCallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): RetrofitService {
        return retrofit.create(RetrofitService::class.java)
    }

    @Singleton
    @Provides
    fun providePokemonRepository(
        database: PokedexDatabase,
        retrofitService: RetrofitService,
    ): PokemonRepository {
        return PokemonRepositoryImpl(database, retrofitService)
    }

    @Singleton
    @Provides
    fun providePokemonUseCase(pokemonRepository: PokemonRepository): PokemonUseCase {
        return PokemonUseCaseImpl(pokemonRepository)
    }

    @Singleton
    @Provides
    fun providePokedexRepository(
        database: PokedexDatabase,
        retrofitService: RetrofitService,
    ): PokedexRepository {
        return PokedexRepositoryImpl(database, retrofitService)
    }

    @Singleton
    @Provides
    fun providePokedexUseCase(pokedexRepository: PokedexRepository): PokedexUseCase {
        return PokedexUseCaseImpl(pokedexRepository)
    }


}