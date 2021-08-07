package com.alex.pokemonlist.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.alex.pokemonlist.databinding.FragmentFavouriteBinding
import com.alex.pokemonlist.presentation.view.adapter.PokemonAdapter
import com.alex.pokemonlist.presentation.viewmodel.FavouriteViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavouriteFragment : Fragment() {
    private val favouritePokemonViewModel: FavouriteViewModel by viewModels()
    private lateinit var binding: FragmentFavouriteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }
    private fun initViews(){
        val recyclerView = binding.recyclerView
        val layoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = view?.let { PokemonAdapter(favouritePokemonViewModel.getListPokemon(), it.context) }
    }

}