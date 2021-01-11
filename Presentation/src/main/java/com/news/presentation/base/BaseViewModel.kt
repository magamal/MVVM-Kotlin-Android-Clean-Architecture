package com.news.presentation.base

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
abstract class BaseViewModel : ViewModel() {
    private val disposables = CompositeDisposable()

    protected fun addDisposale(disposable: Disposable) = disposables.add(disposable)

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }

}