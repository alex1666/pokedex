package com.alex.pokemonlist.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alex.pokemonlist.domain.model.Pokedex


@Dao
interface PokedexDAO {

    @Query("SELECT * FROM pokedex")
    fun all(): List<Pokedex>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(pokemon: List<Pokedex>)

}
