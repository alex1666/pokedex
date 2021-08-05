package com.alex.pokemonlist.di

import dagger.Provides
import androidx.room.Room
import android.app.Application
import com.alex.pokemonlist.data.source.local.PokemonDatabase
import com.alex.pokemonlist.data.source.local.PokedexDatabase
import com.alex.pokemonlist.data.source.local.dao.PokedexDAO
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.alex.pokemonlist.data.source.local.dao.PokemonDAO
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    internal fun providePokemonDatabase(application: Application): PokemonDatabase {
        return Room.databaseBuilder(
            application,
            PokemonDatabase::class.java,
            "pokemonlist"
        ).allowMainThreadQueries().build()
    }

    @Provides
    @Singleton
    internal fun providePokedexDatabase(application: Application): PokedexDatabase {
        return Room.databaseBuilder(
            application,
            PokedexDatabase::class.java,
            "pokedex"
        ).allowMainThreadQueries().build()
    }


    @Provides
    internal fun providePokemonDAO(pokemonDatabase: PokemonDatabase): PokemonDAO {
        return pokemonDatabase.pokemonDAO()
    }
    @Provides
    internal fun providePokedexDAO(pokedex: PokedexDatabase): PokedexDAO {
        return pokedex.pokedexDAO()
    }
}