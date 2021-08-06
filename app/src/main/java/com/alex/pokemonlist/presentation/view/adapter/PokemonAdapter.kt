package com.alex.pokemonlist.presentation.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alex.pokemonlist.R
import com.alex.pokemonlist.databinding.PokemonItemBinding
import com.alex.pokemonlist.domain.model.Pokedex
import com.squareup.picasso.Picasso

class PokemonAdapter(
    private val list: List<Pokedex>,
    private val context: Context,
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var binding: PokemonItemBinding
        fun bindView(item: Pokedex) {

            binding = PokemonItemBinding.bind(itemView)
            binding.root
            with(binding) {
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
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.pokemon_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}




