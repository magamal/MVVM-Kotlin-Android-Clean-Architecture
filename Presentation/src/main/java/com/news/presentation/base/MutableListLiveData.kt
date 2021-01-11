package com.news.presentation.base

import androidx.lifecycle.LifecycleOwner

/**
 * @author Mahmoud Gamal on 1/7/21.
 */
class MutableListLiveData<T> : MutableResourceLiveData<Pair<List<T>, List<T>>>() {

    fun addItems(items: List<T>?) {
        items?.let { items ->
            val oldValues = value?.values?.first ?: emptyList()
            success(
                Pair(
                    first = items,
                    second = ArrayList(oldValues)
                        .apply {
                            addAll(items)
                        }
                )
            )
        }
    }

    fun postAddItems(items: List<T>?) {
        items?.let { items ->
            val oldValues = value?.values?.first ?: emptyList()
            postSuccess(
                Pair(
                    first = items,
                    second = ArrayList(oldValues)
                        .apply {
                            addAll(items)
                        }
                )
            )
        }
    }

    fun observe(
        owner: LifecycleOwner,
        onLoading: () -> Unit,
        onError: (Throwable?) -> Unit,
        onNewData: (List<T>, List<T>) -> Unit
    ) {
        super.observe(owner, object : ListLiveDataObserver<T>() {
            override fun onLoading() = onLoading()

            override fun onError(throwable: Throwable?) = onError(throwable)

            override fun onNewData(newItems: List<T>, allItems: List<T>) =
                onNewData(newItems, allItems)

        })
    }


}