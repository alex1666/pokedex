package com.alex.pokemonlist.domain.model

import androidx.room.TypeConverters
import com.alex.pokemonlist.util.MyCustomTypeConverter

@TypeConverters(MyCustomTypeConverter::class)
data class Family(
    val evolutionLine:List<String>
)
