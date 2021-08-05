package com.alex.pokemonlist.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.alex.pokemonlist.databinding.FragmentListBinding
import com.alex.pokemonlist.domain.model.Pokedex
import com.alex.pokemonlist.domain.model.Pokemon
import com.alex.pokemonlist.presentation.viewmodel.PokedexViewModel
import com.livermor.delegateadapter.delegate.CompositeDelegateAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PokedexFragment : Fragment() {
    val pokedexViewModel: PokedexViewModel by viewModels()
    private lateinit var binding: FragmentListBinding
    private val adapter by lazy {
        CompositeDelegateAdapter(
            PokedexAdapter()
        )
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokedexViewModel.refreshData()
        binding.recyclerView.adapter = adapter
       setObserve()
    }



    private fun setObserve() {
        pokedexViewModel.getPokedexModel().observe(viewLifecycleOwner, { PokedexModel ->
            PokedexModel?.let {
                adapter.swapData(it.pokemon)
            }
        })
    }

}