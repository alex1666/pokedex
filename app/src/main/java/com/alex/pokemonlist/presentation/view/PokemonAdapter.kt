package com.alex.pokemonlist.presentation.view
//
//import android.widget.ImageView
//import com.alex.pokemonlist.databinding.PokemonItemBinding
//import com.alex.pokemonlist.domain.model.Pokedex
//import com.alex.pokemonlist.util.Constants.baseImg
//import com.livermor.delegateadapter.delegate.ViewBindingDelegateAdapter
//import com.squareup.picasso.Picasso
//
//class PokemonAdapter : ViewBindingDelegateAdapter<Pokedex, PokemonItemBinding>(PokemonItemBinding::inflate)
//{
//
//        override fun isForViewType(item: Any) = item is Pokedex
//
//        override fun Pokedex.getItemId() = hashCode()
//
//        override fun PokemonItemBinding.onBind(item: Pokedex) {
//
//            pokemonId.text=item.id
//            pokemonName.text = item.name
//            pokemonHeight.text = item.height
//            pokemonWeight.text = item.weight
//            pokemonSpecies.text = item.species
//            pokemonImg.downloadAndAetImage(item.id)
//        }
//
//        private fun ImageView.downloadAndAetImage(id: String) {
//            Picasso.get()
//                .load(baseImg+"${id}.png")
//                .fit()
//                .into(this)
//        }
//}