package com.alex.pokemonlist.presentation.adapter

import android.annotation.SuppressLint
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import androidx.core.content.ContextCompat
import com.alex.pokemonlist.databinding.PokemonItemBinding
import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.util.PokemonColorUtil
import com.livermor.delegateadapter.delegate.ViewBindingDelegateAdapter
import com.squareup.picasso.Picasso

class PokemonAdapter() :
    ViewBindingDelegateAdapter<Pokemon, PokemonItemBinding>(PokemonItemBinding::inflate) {
    override fun isForViewType(item: Any) = item is Pokemon

    override fun Pokemon.getItemId() = hashCode()

    @SuppressLint("ResourceType")
    override fun PokemonItemBinding.onBind(item: Pokemon) {
        val color = PokemonColorUtil().getPokemonColor(item.typeOfPokemon)
        relativeLayoutBackground.background.colorFilter =
            PorterDuffColorFilter(ContextCompat.getColor(relativeLayoutBackground.context, color),
                PorterDuff.Mode.SRC_ATOP)
        pokemonId.text = item.id
        pokemonName.text = item.name
        pokemonHeight.text = item.height
        pokemonWeight.text = item.weight
        pokemonSpecies.text = item.typeOfPokemon.toString()
        Picasso.get()
            .load(item.imageUrl)
            .fit()
            .into(pokemonImg)
    }

}



