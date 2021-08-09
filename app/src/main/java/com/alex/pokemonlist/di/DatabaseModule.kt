package com.alex.pokemonlist.di

import android.app.Application
import androidx.room.Room
import com.alex.pokemonlist.data.source.local.FavouriteDatabase
import com.alex.pokemonlist.data.source.local.PokemonDatabase
import com.alex.pokemonlist.data.source.local.dao.FavouriteDAO
import com.alex.pokemonlist.data.source.local.dao.PokemonDAO
import com.alex.pokemonlist.domain.model.Favourite
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
            application,
            PokemonDatabase::class.java,
            "pokemonlist"
        ).allowMainThreadQueries().build()
    }

    @Provides
    internal fun providePokemonDAO(pokemonDatabase: PokemonDatabase): PokemonDAO {
        return pokemonDatabase.pokemonDAO()
    }
    @Provides
    @Singleton
    internal fun provideFavouriteDatabase(application: Application): FavouriteDatabase {
        return Room.databaseBuilder(
            application,
            FavouriteDatabase::class.java,
            "pokemonlistfavourite"
        ).allowMainThreadQueries().build()
    }

    @Provides
    internal fun provideFavouriteDAO(favouriteDatabase: FavouriteDatabase): FavouriteDAO {
        return favouriteDatabase.favouriteDao()
    }

}