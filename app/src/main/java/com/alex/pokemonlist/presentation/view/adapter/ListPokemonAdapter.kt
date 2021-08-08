package com.alex.pokemonlist.presentation.view.adapter

import com.alex.pokemonlist.databinding.PokemonItemBinding
import com.alex.pokemonlist.domain.model.Pokemon
import com.livermor.delegateadapter.delegate.ViewBindingDelegateAdapter

class ListPokemonAdapter :
    ViewBindingDelegateAdapter<Pokemon, PokemonItemBinding>(PokemonItemBinding::inflate) {
    override fun isForViewType(item: Any) = item is Pokemon

    override fun Pokemon.getItemId() = hashCode()

    override fun PokemonItemBinding.onBind(item: Pokemon) {
        pokemonId.text = item.id
        pokemonName.text = item.name
        pokemonHeight.text = item.height
        pokemonWeight.text = item.weight
        pokemonSpecies.text = item.typeOfPokemon.toString()
        com.squareup.picasso.Picasso.get()
            .load(item.imageUrl)
            .fit()
            .into(pokemonImg)
    }

}






