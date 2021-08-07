package com.alex.pokemonlist.di

import android.app.Application
import androidx.room.Room
import com.alex.pokemonlist.data.source.local.PokedexDatabase
import com.alex.pokemonlist.data.source.local.dao.PokedexDAO
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
    internal fun providePokemonDatabase(application: Application): PokedexDatabase {
        return Room.databaseBuilder(
            application,
            PokedexDatabase::class.java,
            "pokemonlist"
        ).allowMainThreadQueries().build()
    }

    @Provides
    internal fun providePokedexDAO(pokemonDatabase: PokedexDatabase): PokedexDAO {
        return pokemonDatabase.pokedexDAO()
    }

}