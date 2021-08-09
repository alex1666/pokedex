package com.alex.pokemonlist.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.alex.pokemonlist.R
import com.alex.pokemonlist.databinding.FragmentMenuBinding
import com.alex.pokemonlist.presentation.viewmodel.MenuViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    val menuViewModel: MenuViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        menuViewModel.refreshData()
        with(binding) {
            imgRandom.setOnClickListener {
                it.findNavController().navigate(R.id.action_menuFragment_to_searchFragment)
            }
            imgFavourite.setOnClickListener {
                it.findNavController().navigate(R.id.action_menuFragment_to_favouriteFragment)
            }
            imgList.setOnClickListener {
                it.findNavController().navigate(R.id.action_menuFragment_to_listFragment)
            }
        }
    }
}