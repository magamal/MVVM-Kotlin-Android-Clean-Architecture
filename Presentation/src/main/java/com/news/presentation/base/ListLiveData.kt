package com.news.presentation.base

import androidx.lifecycle.MutableLiveData

/**
 * Created by Mahmoud Gamal on 2019-09-07.
 * @param Pair<List,List>
 *     the first list is for all items
 *     the second is for added items
 */
class ListLiveData<T> : MutableLiveData<Pair<ArrayList<T>,ArrayList<T>>>() {
    private var addedItems = ArrayList<T>()

    fun addItem(items:List<T>){
        addedItems = items as ArrayList<T>
        var allItems = value
        if (allItems == null || allItems?.first == null)
            allItems = Pair(arrayListOf(), arrayListOf())

        allItems.first.addAll(items)
        allItems.second.clear()
        allItems.second.addAll(items)
        value = allItems
    }
}