package com.alex.pokemonlist.presentation.view.adapter

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.view.View
import com.alex.pokemonlist.databinding.PokemonItemBinding
import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.util.PokemonColorUtil
import com.livermor.delegateadapter.delegate.ViewBindingDelegateAdapter
import com.squareup.picasso.Picasso


class ListPokemonAdapter() :
    ViewBindingDelegateAdapter<Pokemon, PokemonItemBinding>(PokemonItemBinding::inflate) {
    override fun isForViewType(item: Any) = item is Pokemon

    override fun Pokemon.getItemId() = hashCode()

    override fun PokemonItemBinding.onBind(item: Pokemon) {
        val color = PokemonColorUtil().getPokemonColor(item.typeOfPokemon)
        relativeLayoutBackground.background.colorFilter =
            PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP)
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







