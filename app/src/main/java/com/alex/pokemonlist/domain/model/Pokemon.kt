package com.alex.pokemonlist.domain.model

import androidx.room.TypeConverters
import com.alex.pokemonlist.util.ListStringConverter

@TypeConverters(ListStringConverter::class)
class Pokemon(
    val id: String,
    val name: String,
    val height: String,
    val weight: String,
    val typeofpokemon: List<String>? = null,
    val imageurl: String,
)
