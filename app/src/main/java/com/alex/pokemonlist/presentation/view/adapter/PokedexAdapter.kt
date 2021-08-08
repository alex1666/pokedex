package com.alex.pokemonlist.presentation.view.adapter

import com.alex.pokemonlist.databinding.PokemonItemBinding
import com.alex.pokemonlist.domain.model.Pokedex
import com.alex.pokemonlist.domain.model.Pokemon
import com.livermor.delegateadapter.delegate.ViewBindingDelegateAdapter
import com.squareup.picasso.Picasso

class PokedexAdapter :
    ViewBindingDelegateAdapter<Pokedex, PokemonItemBinding>(PokemonItemBinding::inflate) {
    override fun isForViewType(item: Any) = item is Pokedex

    override fun Pokedex.getItemId() = hashCode()

    override fun PokemonItemBinding.onBind(item: Pokedex) {
        pokemonId.text = item.id.toString()
        pokemonName.text = item.name
        pokemonHeight.text = item.height
        pokemonWeight.text = item.weight
        pokemonSpecies.text = item.species
        Picasso.get()
            .load(item.icon)
            .fit()
            .into(pokemonImg)
    }

}



