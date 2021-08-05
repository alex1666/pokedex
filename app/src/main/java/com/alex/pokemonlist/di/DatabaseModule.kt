package com.alex.pokemonlist.di

import dagger.Provides
import androidx.room.Room
import android.app.Application
import com.alex.pokemonlist.data.source.local.AppDatabase
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
    internal fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            "pokemonlist"
        ).allowMainThreadQueries().build()
    }


    @Provides
    internal fun providePokemonDAO(appDatabase: AppDatabase): PokemonDAO {
        return appDatabase.pokemonDAO()
    }
}