package com.alex.pokemonlist.util

import androidx.annotation.ColorInt
import com.alex.pokemonlist.R

class PokemonColorUtil() {

    @ColorInt
    fun getPokemonColor(typeOfPokemon: List<String>?): Int {
        val color = when (typeOfPokemon?.getOrNull(0)) {
            "Grass", "Bug" -> R.color.lightTeal
            "Fire" -> R.color.lightRed
            "Water", "Fighting", "Normal" -> R.color.lightBlue
            "Electric", "Psychic" -> R.color.lightYellow
            "Poison", "Ghost" -> R.color.lightPurple
            "Ground", "Rock" -> R.color.lightBrown
            "Dark" -> R.color.black
            else -> R.color.lightBlue
        }
        return color
    }
}
