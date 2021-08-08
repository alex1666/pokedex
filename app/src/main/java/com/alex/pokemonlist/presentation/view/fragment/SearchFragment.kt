package com.alex.pokemonlist.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import com.alex.pokemonlist.databinding.FragmentSearchBinding
import com.alex.pokemonlist.domain.model.Pokedex
import com.alex.pokemonlist.presentation.view.adapter.PokedexAdapter
import com.alex.pokemonlist.presentation.viewmodel.SearchViewModel
import com.livermor.delegateadapter.delegate.CompositeDelegateAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchFragment : Fragment() {
    var pokeName: String = "1"
    private val searchViewModel: SearchViewModel by viewModels()
    private lateinit var binding: FragmentSearchBinding
    private val listEvolution = mutableListOf<Pokedex>()

    private val adapterPokemon by lazy {
        CompositeDelegateAdapter(
            PokedexAdapter()
        )
    }
    private val adapterEvolution by lazy {
        CompositeDelegateAdapter(
            PokedexAdapter()
        )
    }

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


    private fun setPokemon(it: List<Pokedex>) {
        binding.recyclerViewPokemon.layoutManager = GridLayoutManager(context, 1)
        adapterPokemon.swapData(it)
        binding.recyclerViewPokemon.adapter = adapterPokemon

    }

    private fun setObserve() {
        searchViewModel.getPokedexModel().observe(viewLifecycleOwner, { PokemonModel ->
            PokemonModel?.let {
                setPokemon(it)
                getEvolution(it)



            }
        })
    }
    private fun Observe() {
        searchViewModel.getPokedexModel().observe(viewLifecycleOwner, { PokemonModel ->
            PokemonModel?.let {
            listEvolution.addAll(it)
            }
        })
    }

    private fun getEvolution(it: List<Pokedex>) {
        val evolutions = it.get(0).family?.evolutionLine
        if (evolutions != null) {
            evolutions.getOrNull(1).let {
                searchViewModel.refreshData(evolutions[1])
                    Observe()
            }?: run { binding.pokemonFamily.text = "Эволюций нет" }

            evolutions.getOrNull(2).let {
                searchViewModel.refreshData(evolutions[1])
                Observe()
            }
        }
//        adapterEvolution.swapData(listEvolution)
//        binding.recyclerViewEvolution.layoutManager = GridLayoutManager(context, 1)
//        binding.recyclerViewEvolution.adapter = adapterEvolution
    }

    private fun add() {
        searchViewModel.getPokedexModel().observe(viewLifecycleOwner, { PokedexModel ->
            PokedexModel?.let {
                searchViewModel.addPokedex(PokedexModel)
            }
        })
    }


}


