package com.alex.pokemonlist.domain.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.alex.pokemonlist.util.MyCustomTypeConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "pokemon")
@TypeConverters(MyCustomTypeConverter::class)
class Pokemon(
    @PrimaryKey @NonNull
    val id: String,
    val name: String,
    val height: String,
    val weight: String,
    @SerializedName("typeofpokemon")
    val typeOfPokemon: List<String>? = null,
    @SerializedName("imageurl")
    val imageUrl: String,
    val evolutions:List<String>? = null
)
