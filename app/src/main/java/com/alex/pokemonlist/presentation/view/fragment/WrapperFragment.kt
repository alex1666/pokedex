package com.alex.pokemonlist.presentation.view.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.alex.pokemonlist.R
import com.alex.pokemonlist.presentation.viewmodel.WrapperViewModel
import com.alex.pokemonlist.util.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WrapperFragment : Fragment() {
    private val wrapperViewModel: WrapperViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_wrapper, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getMenu()
    }

    private fun getMenu() {
        Handler().postDelayed({
            wrapperViewModel.refreshData()
            findNavController().navigate(R.id.action_wrapperFragment_to_menuFragment)
        }, Constants.wallpaperTime.toLong())

    }
}
