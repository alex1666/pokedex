package com.alex.pokemonlist.domain.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.alex.pokemonlist.util.ListStringConverter
import com.google.gson.annotations.SerializedName
@Entity(tableName = "pokemon")
@TypeConverters(ListStringConverter::class)
class Pokemon(
    @PrimaryKey @NonNull
    val id: Int,
    val num: String,
    val name:String,
    val height: String,
    val weight: String,
    val img: String
)
