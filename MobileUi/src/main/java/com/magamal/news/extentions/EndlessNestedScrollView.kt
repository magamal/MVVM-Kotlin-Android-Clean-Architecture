package com.magamal.news.extentions

import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Mahmoud Gamal on 2019-09-09.
 */
fun RecyclerView.addEndlessScroll(loadMore: () -> Unit) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val linearLayoutManager =
                recyclerView.layoutManager as LinearLayoutManager?
            adapter?.itemCount?.let { itemCount ->
                if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == itemCount - 1) {
                    loadMore()
                }
            }
        }
    })
}

fun NestedScrollView.addEndlessScroll(loadMore: () -> Unit) {
    setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, _, scrollY, _, oldScrollY ->
        if (v.getChildAt(v.childCount - 1) != null) {
            if (scrollY >= v.getChildAt(v.childCount - 1).measuredHeight - v.measuredHeight && scrollY > oldScrollY) {
                loadMore()
            }
        }
    })
}