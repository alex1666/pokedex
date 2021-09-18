package com.alex.pokemonlist.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.GridLayoutManager
import com.alex.pokemonlist.databinding.FragmentFavouriteBinding
import com.alex.pokemonlist.presentation.view.adapter.ListPokemonAdapter
import com.alex.pokemonlist.presentation.viewmodel.FavouriteViewModel
import com.livermor.delegateadapter.delegate.CompositeDelegateAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavouriteFragment : Fragment() {
    private val favouritePokemonViewModel: FavouriteViewModel by viewModels()
    private lateinit var binding: FragmentFavouriteBinding
    private val adapter by lazy {
        CompositeDelegateAdapter(
            ListPokemonAdapter()
        )
    }

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

    private fun initViews() {
        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        favouritePokemonViewModel.getFavourite().asLiveData().observe(viewLifecycleOwner,{list-> adapter.swapData(list) })
        binding.recyclerView.adapter = adapter
    }

}

