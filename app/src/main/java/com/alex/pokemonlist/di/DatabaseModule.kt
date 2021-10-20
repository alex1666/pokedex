package com.alex.pokemonlist.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.alex.pokemonlist.data.source.local.PokemonDatabase
import com.alex.pokemonlist.data.source.local.dao.PokemonDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    @Singleton
    internal fun providePokemonDatabase(application: Application): PokemonDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            PokemonDatabase::class.java,
            "pokemonlist"
        ).build()
    }

    @Provides
    internal fun providePokemonDAO(pokemonDatabase: PokemonDatabase): PokemonDAO {
        return pokemonDatabase.pokemonDAO()
    }
}