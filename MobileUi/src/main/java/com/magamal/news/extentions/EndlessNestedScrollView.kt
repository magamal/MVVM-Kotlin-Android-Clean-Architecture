package com.magamal.news.extentions

import androidx.core.widget.NestedScrollView
import com.magamal.news.ui.news.MainActivity

/**
 * Created by Mahmoud Gamal on 2019-09-09.
 */
fun NestedScrollView.addEndlessScroll(loadMore:()->Unit){
    setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
        if (v.getChildAt(v.getChildCount() - 1) != null) {
            if (scrollY >= v.getChildAt(v.getChildCount() - 1).getMeasuredHeight() - v.getMeasuredHeight() && scrollY > oldScrollY) {
                loadMore()
            }
        }
    })
}