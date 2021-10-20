package com.alex.pokemonlist.di

import com.alex.pokemonlist.data.repository.PokemonRepositoryImpl
import com.alex.pokemonlist.data.source.local.PokemonDatabase
import com.alex.pokemonlist.data.source.remote.PokemonApi
import com.alex.pokemonlist.domain.repository.PokemonRepository
import com.alex.pokemonlist.domain.interactor.PokemonInteractor
import com.alex.pokemonlist.domain.interactor.PokemonInteractorImpl
import com.alex.pokemonlist.util.Constants.BASE_URL
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
    fun providesRetrofitPokemon(
        gsonConverterFactory: GsonConverterFactory,
        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
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
    fun provideService(retrofit: Retrofit): PokemonApi {
        return retrofit.create(PokemonApi::class.java)
    }

}