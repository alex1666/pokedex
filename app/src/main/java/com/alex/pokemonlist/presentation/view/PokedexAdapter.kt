package com.alex.pokemonlist.presentation.view

import com.alex.pokemonlist.databinding.PokemonItemBinding
import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.util.Constants.num
import com.livermor.delegateadapter.delegate.ViewBindingDelegateAdapter

class PokedexAdapter :
    ViewBindingDelegateAdapter<Pokemon, PokemonItemBinding>(PokemonItemBinding::inflate) {

    override fun isForViewType(item: Any) = item is Pokemon

    override fun Pokemon.getItemId() = hashCode()

    override fun PokemonItemBinding.onBind(item: Pokemon) {

        pokemonId.text = num + item.id.toString()
        pokemonName.text = item.name
        pokemonHeight.text = item.height
        pokemonWeight.text = item.weight
        //pokemonSpecies.text = item.type
        com.squareup.picasso.Picasso.get()
            .load(item.img)
            .fit()
            .into(pokemonImg)
    }

}






