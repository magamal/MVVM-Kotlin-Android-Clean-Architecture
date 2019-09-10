package com.magamal.news.widgets

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


/**
 * Created by Mahmoud Gamal on 5/19/19.
 */
abstract class EndlessRecyclerOnScrollListener : RecyclerView.OnScrollListener() {


    /**
     * The total number of items in the dataset after the last load
     */
    private var mPreviousTotal = 0
    /**
     * True if we are still waiting for the last set of data to load.
     */
    private var mLoading = true

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)


        val visibleItemCount = recyclerView.childCount
        val totalItemCount = recyclerView.layoutManager!!.getItemCount()
        val firstVisibleItem = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

        if (mLoading) {
            if (totalItemCount > mPreviousTotal) {
                mLoading = false
                mPreviousTotal = totalItemCount
            }
        }
        val visibleThreshold = 5
        if (!mLoading && totalItemCount - visibleItemCount <= firstVisibleItem + visibleThreshold) {
            // End has been reached

            onLoadMore()

            mLoading = true
        }
    }

    fun reset(previousTotal: Int, loading: Boolean) {
        mPreviousTotal = previousTotal
        mLoading = loading
    }

    abstract fun onLoadMore()

}