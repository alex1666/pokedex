package com.alex.pokemonlist.presentation.pokemonsearch

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import com.alex.pokemonlist.databinding.FragmentSearchBinding
import com.alex.pokemonlist.presentation.adapter.ListPokemonAdapter
import com.livermor.delegateadapter.delegate.CompositeDelegateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SearchFragment : Fragment() {
    private var pokeName: String = "#001"
    private val searchViewModel: SearchViewModel by viewModels()
    private lateinit var binding: FragmentSearchBinding

    private val adapterPokemon by lazy {
        CompositeDelegateAdapter(
            ListPokemonAdapter()
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
        init()
        initViews()
    }

    private fun initViews() {
        with(binding) {
            imgAddFavourite.setOnClickListener {
                searchViewModel.viewModelScope.launch {
                    searchViewModel.addFavourite(pokeName)
                }
            }
            imgSearch.setOnClickListener {
                Log.e("SHIT", "name= 1")
                pokeName = searchPokemon.text.toString()
                try {
                    setPokemonByName()
                } catch (e: IndexOutOfBoundsException) {
                    null
                }
                try {
                    toNumber()
                    setPokemonById()
                } catch (e: IndexOutOfBoundsException) {
                    null
                }

            }

            imgRandom.setOnClickListener {
                Log.e("SHIT", "name= 2")
                pokeName = (0..809).random().toString()
                toNumber()

                searchViewModel.viewModelScope.launch {
                    setPokemonById()
                }
            }
        }
    }

    private fun init() {
        binding.recyclerViewPokemon.layoutManager = GridLayoutManager(context, 1)
        binding.recyclerViewPokemon.adapter = adapterPokemon
        searchViewModel.viewModelScope.launch {
            setPokemonById()
        }
    }

    private fun setPokemonById() {
        Log.e("SHIT", "name= $pokeName")

        searchViewModel.viewModelScope.launch {
            adapterPokemon.swapData(
                searchViewModel.getPokemonById(
                    pokeName
                )
            )
        }

    }

    private fun setPokemonByName() {
        searchViewModel.viewModelScope.launch {
            adapterPokemon.swapData(searchViewModel.getPokemonByName(pokeName))
        }
    }

    private fun toNumber() {
        if (pokeName.length == 1)
            pokeName = "#00$pokeName"
        if (pokeName.length == 2)
            pokeName = "#0$pokeName"
        if (pokeName.length == 3)
            pokeName = "#$pokeName"
    }

}


