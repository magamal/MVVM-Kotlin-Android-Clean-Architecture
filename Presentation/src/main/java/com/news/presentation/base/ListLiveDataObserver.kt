package com.news.presentation.base

import androidx.lifecycle.Observer

/**
 * @author Mahmoud Gamal on 1/7/21.
 */
abstract class ListLiveDataObserver<T> : Observer<Resource<Pair<List<T>, List<T>>>> {
    override fun onChanged(resource: Resource<Pair<List<T>, List<T>>>?) {
        when (resource?.state) {
            Resource.State.LOADING -> {
                onLoading()
            }
            Resource.State.ERROR -> {
                onError(resource.throwable)
            }
            Resource.State.SUCCESS -> {
                resource.values?.let { values ->
                    val newItems = values.first
                    val allItems = values.second
                    onNewData(newItems = newItems, allItems = allItems)
                }
            }
        }
    }

    abstract fun onLoading()
    abstract fun onError(throwable: Throwable?)
    abstract fun onNewData(newItems: List<T>, allItems: List<T>)
}