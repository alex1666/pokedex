package com.alex.pokemonlist.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alex.pokemonlist.data.source.local.dao.PokedexDAO
import com.alex.pokemonlist.data.source.local.dao.PokemonDAO
import com.alex.pokemonlist.domain.model.Pokemon

@Database(entities = [Pokemon::class], version = 5)
abstract class PokemonDatabase : RoomDatabase() {

    abstract fun pokemonDAO(): PokemonDAO
}
