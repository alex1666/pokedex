package com.alex.pokemonlist.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.alex.pokemonlist.databinding.FragmentSearchBinding
import com.alex.pokemonlist.domain.model.Favourite
import com.alex.pokemonlist.presentation.view.adapter.PokedexAdapter
import com.alex.pokemonlist.presentation.viewmodel.SearchViewModel
import com.livermor.delegateadapter.delegate.CompositeDelegateAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchFragment : Fragment() {
    var pokeName: String = "#001"
    private val searchViewModel: SearchViewModel by viewModels()
    private lateinit var binding: FragmentSearchBinding

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
        init()
        initViews()
    }

    private fun initViews() {
        with(binding) {

            imgAddFavourite.setOnClickListener {
                val favourite: Favourite = Favourite("$pokeName")
                searchViewModel.addFavourite(favourite)
            }
            imgSearch.setOnClickListener {
                pokeName = searchPokemon.text.toString()
                try {
                    searchViewModel.getPokemonByName(pokeName)
                    setPokemonByName()

                } catch (e: IndexOutOfBoundsException) {
                    null
                }
                try {
                    toNumber()
                    searchViewModel.getPokemonById(pokeName)
                    setPokemonById()
                } catch (e: IndexOutOfBoundsException) {
                    null
                }

            }

            imgRandom.setOnClickListener {
                pokeName = (0..809).random().toString()
                toNumber()
                setPokemonById()
            }
        }
    }


    private fun init() {
        binding.recyclerViewEvolution.layoutManager = GridLayoutManager(context, 1)
        binding.recyclerViewEvolution.adapter = adapterEvolution
        setPokemonById()
    }

    private fun setPokemonById() {
        searchViewModel.getPokemonById(pokeName).get(0).evolutions?.let {
            searchViewModel.getEvolution(it)
        }?.let { adapterEvolution.swapData(it) }
        searchViewModel.getPokemonById(pokeName).get(0).evolutions?.let {
            if (it.size != 1)
                binding.pokemonFamily.text = "Pokemon and he's evolution line"
            else
                binding.pokemonFamily.text = "Pokemon"
        }

    }

    private fun setPokemonByName() {
        searchViewModel.getPokemonByName(pokeName).get(0).evolutions?.let {
            searchViewModel.getEvolution(it)

        }?.let { adapterEvolution.swapData(it) }
        searchViewModel.getPokemonByName(pokeName).get(0).evolutions?.let {
            if (it.size != 1)
                binding.pokemonFamily.text = "Pokemon and he's evolution line"
            else
                binding.pokemonFamily.text = "Pokemon"
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


