package com.alex.pokemonlist.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alex.pokemonlist.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow


@Dao
interface PokemonDAO {

    @Query("SELECT * FROM pokemon")
    fun all(): LiveData<List<Pokemon>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(pokemon: List<Pokemon>)

    @Query("SELECT * FROM pokemon WHERE id = :id")
    fun getById(id: String): LiveData<List<Pokemon>>

    @Query("SELECT * FROM pokemon WHERE name = :name")
    fun getByName(name: String): LiveData<List<Pokemon>>

    @Query("SELECT * FROM pokemon WHERE id IN(:Ids)")
    fun getByIds(Ids: List<String>): LiveData<List<Pokemon>>

    @Query("SELECT * FROM pokemon WHERE favourite")
    fun getFavourite(): LiveData<List<Pokemon>>

    @Query("UPDATE pokemon SET favourite=:favourite WHERE id=:name")
    fun addFavourite(name: String, favourite: Boolean)
    @Query("SELECT * FROM pokemon WHERE name=:name and favourite =:favourite")
    fun checkFavourite(name: String, favourite: Boolean):LiveData<List<Pokemon>>


}
