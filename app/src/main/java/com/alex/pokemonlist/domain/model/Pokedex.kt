package com.alex.pokemonlist.domain.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "pokedex")
class Pokedex(
    @SerializedName("number")
    @PrimaryKey @NonNull
    val id: Int,
    val name: String,
    val height: String,
    val weight: String,
    val species: String,
    @SerializedName("sprite")
    val icon: String,
)