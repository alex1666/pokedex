package com.alex.pokemonlist.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alex.pokemonlist.data.source.local.dao.FavouriteDAO
import com.alex.pokemonlist.data.source.local.dao.PokemonDAO
import com.alex.pokemonlist.domain.model.Favourite
import com.alex.pokemonlist.domain.model.Pokemon

@Database(entities = [Favourite::class], version = 5)
abstract class FavouriteDatabase : RoomDatabase() {

    abstract fun favouriteDao(): FavouriteDAO
}
