package com.magamal.news.extentions

import android.widget.ImageView
import com.magamal.news.R
import com.squareup.picasso.Picasso

/**
 * Created by Mahmoud Gamal on 2019-09-07.
 */

fun ImageView.loadImage(url: String?) {
    Picasso
        .with(context)
        .load(url)
        .error(R.drawable.boarder)
        .placeholder(R.drawable.boarder)
        .into(this)
}