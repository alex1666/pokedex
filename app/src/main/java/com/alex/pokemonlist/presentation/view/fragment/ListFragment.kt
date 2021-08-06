package com.alex.pokemonlist.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.alex.pokemonlist.databinding.FragmentListBinding
import com.alex.pokemonlist.presentation.view.adapter.ListAdapter
import com.alex.pokemonlist.presentation.viewmodel.ListViewModel
import com.livermor.delegateadapter.delegate.CompositeDelegateAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ListFragment : Fragment() {
    val pokedexViewModel: ListViewModel by viewModels()
    private lateinit var binding: FragmentListBinding
    private val adapter by lazy {
        CompositeDelegateAdapter(
            ListAdapter()
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
        setObserve()

        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.adapter = adapter
    }

    private fun setObserve() {
        pokedexViewModel.getPokemonModel().observe(viewLifecycleOwner, { PokemonModel ->
            PokemonModel?.let {
                adapter.swapData(it)
            }
        })
    }

}