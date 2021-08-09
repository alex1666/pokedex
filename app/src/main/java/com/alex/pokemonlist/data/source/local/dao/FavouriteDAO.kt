package com.alex.pokemonlist.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alex.pokemonlist.domain.model.Favourite
import com.alex.pokemonlist.domain.model.Pokemon


@Dao
interface FavouriteDAO {

    @Query("SELECT * FROM favourite")
    fun all(): List<Favourite>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(favourite: Favourite)


}
