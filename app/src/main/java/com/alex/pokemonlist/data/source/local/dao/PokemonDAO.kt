package com.alex.pokemonlist.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alex.pokemonlist.domain.model.Pokemon


@Dao
interface PokemonDAO {

    @Query("SELECT * FROM pokemon")
    fun all(): List<Pokemon>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(pokemon: List<Pokemon>)

    @Query("SELECT * FROM pokemon WHERE id = :id")
    fun getById(id: String): List<Pokemon>

    @Query("SELECT * FROM pokemon WHERE name = :name")
    fun getByName(name: String): List<Pokemon>

    @Query("SELECT * FROM pokemon WHERE id IN(:Ids)")
    fun getByIds(Ids: List<String>): List<Pokemon>

    @Query("SELECT * FROM pokemon WHERE favourite")
    fun getFavourite(): List<Pokemon>

    @Query("UPDATE pokemon SET favourite=:favourite WHERE id=:name")
    fun addFavourite(name: String, favourite: Boolean)

}
