package com.alex.pokemonlist.domain.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite")
class Favourite(
    @PrimaryKey @NonNull
    var id: String
)