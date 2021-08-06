package com.alex.pokemonlist.data.source.local.dao

import androidx.room.*
import com.alex.pokemonlist.domain.model.Pokedex


@Dao
interface PokedexDAO {

    @Query("SELECT * FROM pokedex")
    fun all(): List<Pokedex>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(pokedex: List<Pokedex>)

}
