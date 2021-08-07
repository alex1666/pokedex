package com.alex.pokemonlist.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alex.pokemonlist.data.source.local.dao.PokedexDAO
import com.alex.pokemonlist.domain.model.Pokedex

@Database(entities = [Pokedex::class], version = 5)
abstract class PokedexDatabase : RoomDatabase() {

    abstract fun pokedexDAO(): PokedexDAO
}
