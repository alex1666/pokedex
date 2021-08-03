package com.alex.pokemonlist.presentation.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.viewModels
import com.alex.pokemonlist.databinding.FragmentMenuBinding
import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.presentation.viewmodel.PokemonViewModel
import com.alex.pokemonlist.util.Constants.Id
import com.alex.pokemonlist.util.Constants.baseImg
import com.alex.pokemonlist.util.Constants.height
import com.alex.pokemonlist.util.Constants.name
import com.alex.pokemonlist.util.Constants.species
import com.alex.pokemonlist.util.Constants.weight
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MenuFragment : Fragment() {
    private val pokemonViewModel: PokemonViewModel by viewModels()
    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonViewModel.refreshData("1")
        initViews()
        setObserve()
    }

    private fun initViews() {
        with(binding) {
            var pokemonName:String
            imgSearch.setOnClickListener {
                pokemonName = searchPokemon.text.toString()
                pokemonViewModel.refreshData(pokemonName)
            }
            imgRandom.setOnClickListener {
                pokemonName = (0..807).random().toString()
                pokemonViewModel.refreshData(pokemonName)
            }
        }

    }

    @SuppressLint("SetTextI18n")
    private fun setPokemon(it: List<Pokemon>) {
        with(binding) {
            val idImg=it.get(0).number
            pokemonName.text = name+it.get(0).name
            pokemonId.text = Id+it.get(0).number.toString()
            pokemonHeight.text = height+it.get(0).height
            pokemonWeight.text = weight+it.get(0).weight
            pokemonSpecies.text = species+it.get(0).species
            Glide.with(this@MenuFragment)
                .load(baseImg+"${idImg}.png")
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


    private fun ImageView.downloadAndAetImage(id: String) {
        Picasso.get()
            .load(baseImg +"${id}.png")
            .fit()
            .into(this)
    }
}


