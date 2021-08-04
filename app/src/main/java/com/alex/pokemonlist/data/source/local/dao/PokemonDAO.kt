package com.alex.pokemonlist.data.source.local.dao

import androidx.room.*
import com.alex.pokemonlist.domain.model.Pokemon


@Dao
interface PokemonDAO {

    @Query("SELECT * FROM pokemon")
    fun all(): List<Pokemon>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(pokemon: Pokemon)

    @Query("DELETE FROM pokemon")
    fun deleteAll()

    @Delete
    fun delete(model: Pokemon)
}
