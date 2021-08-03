package com.alex.pokemonlist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel: ViewModel(){
    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    fun Disposable.untilCleared(): Disposable {
        addDisposable(this)
        return this
    }

    private fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }
}