package com.alex.pokemonlist.domain.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Poke(
    val pokemon:List<Pokemon>
)
