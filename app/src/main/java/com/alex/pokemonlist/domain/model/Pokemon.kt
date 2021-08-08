package com.alex.pokemonlist.domain.model

import androidx.room.TypeConverters
import com.alex.pokemonlist.util.MyCustomTypeConverter
import com.google.gson.annotations.SerializedName

@TypeConverters(MyCustomTypeConverter::class)
class Pokemon(
    val id: String,
    val name: String,
    val height: String,
    val weight: String,
    @SerializedName("typeofpokemon")
    val typeOfPokemon: List<String>? = null,
    @SerializedName("imageurl")
    val imageUrl: String,
)
