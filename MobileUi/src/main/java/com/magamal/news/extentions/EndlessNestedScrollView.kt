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
            recyclerView
                .takeIf { layoutManager is LinearLayoutManager && adapter?.itemCount != null }
                ?.run { layoutManager as LinearLayoutManager }
                ?.takeIf { linearLayoutManager -> linearLayoutManager.findLastCompletelyVisibleItemPosition() == adapter?.itemCount!! - 1 }
                ?.let { loadMore() }
        }
    })
}

fun NestedScrollView.addEndlessScroll(loadMore: () -> Unit) {
    setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { view, _, scrollY, _, oldScrollY ->
        view.getChildAt(view.childCount - 1)?.measuredHeight
            ?.takeIf { measuredHeight -> scrollY >= measuredHeight - view.measuredHeight && scrollY > oldScrollY }
            ?.run { loadMore() }
    })
}
