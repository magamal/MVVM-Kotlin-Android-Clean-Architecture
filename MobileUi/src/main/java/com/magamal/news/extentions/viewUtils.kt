package com.magamal.news.extentions

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat

/**
 * Created by Mahmoud Gamal on 2019-09-23.
 */
fun View.toVisible() {
    visibility = View.VISIBLE
}

fun View.toGone() {
    visibility = View.GONE
}

fun View.toInvisible() {
    visibility = View.INVISIBLE
}

fun Context.getCompatColor(colorId: Int): Int = ContextCompat.getColor(this, colorId)

fun Context.getCompatDrawable(resId: Int): Drawable? = ContextCompat.getDrawable(this, resId)
