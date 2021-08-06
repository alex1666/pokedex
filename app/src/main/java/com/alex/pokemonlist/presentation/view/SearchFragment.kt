package com.alex.pokemonlist.presentation.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.alex.pokemonlist.databinding.FragmentSearchBinding
import com.alex.pokemonlist.domain.model.Pokedex
import com.alex.pokemonlist.presentation.viewmodel.SearchViewModel
import com.alex.pokemonlist.util.Constants.Id
import com.alex.pokemonlist.util.Constants.height
import com.alex.pokemonlist.util.Constants.name
import com.alex.pokemonlist.util.Constants.species
import com.alex.pokemonlist.util.Constants.weight
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchFragment : Fragment() {
    var pokeName: String = "1"
    private val searchViewModel: SearchViewModel by viewModels()
    private lateinit var binding: FragmentSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchViewModel.refreshData(pokeName)
        initViews()
        setObserve()
    }

    private fun initViews() {
        with(binding) {
            imgAddFavourite.setOnClickListener {
                add()
            }
            imgSearch.setOnClickListener {
                pokeName = searchPokemon.text.toString()
                searchViewModel.refreshData(pokeName)
            }
            imgRandom.setOnClickListener {
                pokeName = (0..807).random().toString()
                searchViewModel.refreshData(pokeName)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setPokemon(it: List<Pokedex>) {
        with(binding) {
            pokemonName.text = name + it.get(0).name
            pokemonId.text = Id + it.get(0).id.toString()
            pokemonHeight.text = height + it.get(0).height
            pokemonWeight.text = weight + it.get(0).weight
            pokemonSpecies.text = species + it.get(0).species
            Glide.with(this@SearchFragment)
                .load(it.get(0).icon)
                .into(pokemonImg)
        }
    }

    private fun setObserve() {
        searchViewModel.getPokemonModel().observe(viewLifecycleOwner, { PokemonModel ->
            PokemonModel?.let {
                setPokemon(it)
            }
        })
    }

    private fun add() {
        searchViewModel.getPokemonModel().observe(viewLifecycleOwner, { PokedexModel ->
            PokedexModel?.let {
                searchViewModel.addPokedex(PokedexModel)
            }
        })
    }


}


