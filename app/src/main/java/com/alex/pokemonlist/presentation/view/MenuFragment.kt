package com.alex.pokemonlist.presentation.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.alex.pokemonlist.R
import com.alex.pokemonlist.databinding.FragmentMenuBinding
import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.presentation.viewmodel.PokemonViewModel
import com.alex.pokemonlist.util.Constants.Id
import com.alex.pokemonlist.util.Constants.height
import com.alex.pokemonlist.util.Constants.name
import com.alex.pokemonlist.util.Constants.species
import com.alex.pokemonlist.util.Constants.weight
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MenuFragment : Fragment() {
    var pokeName: String = "1"
    private val pokemonViewModel: PokemonViewModel by viewModels()
    private lateinit var binding: FragmentMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View{
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonViewModel.refreshData(pokeName)
        initViews()
        setObserve()
    }

    private fun initViews() {
        with(binding) {
            imgAddFavourite.setOnClickListener {
                add()
            }
            imgFavourite.setOnClickListener {
                it.findNavController().navigate(R.id.action_menuFragment_to_favouriteFragment)
            }
            imgSearch.setOnClickListener {
                pokeName = searchPokemon.text.toString()
                pokemonViewModel.refreshData(pokeName)
            }
            imgRandom.setOnClickListener {
                pokeName = (0..807).random().toString()
                pokemonViewModel.refreshData(pokeName)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setPokemon(it: List<Pokemon>) {
        with(binding) {
            pokemonName.text = name + it.get(0).name
            pokemonId.text = Id + it.get(0).id.toString()
            pokemonHeight.text = height + it.get(0).height
            pokemonWeight.text = weight + it.get(0).weight
            pokemonSpecies.text = species + it.get(0).species
            Glide.with(this@MenuFragment)
                .load(it.get(0).icon)
                .into(pokemonImg)
        }

    }

    private fun setObserve() {
        pokemonViewModel.getPokemonModel().observe(viewLifecycleOwner, { PokemonModel ->
            PokemonModel?.let {
                setPokemon(it)
            }
        })
    }

    private fun add() {
        pokemonViewModel.getPokemonModel().observe(viewLifecycleOwner, { PokemonModel ->
            PokemonModel?.let {
                pokemonViewModel.addPokemon(it.get(0).id,
                    it.get(0).name,
                    it.get(0).height,
                    it.get(0).weight,
                    it.get(0).species,
                    it.get(0).icon)
            }
        })
    }


}


