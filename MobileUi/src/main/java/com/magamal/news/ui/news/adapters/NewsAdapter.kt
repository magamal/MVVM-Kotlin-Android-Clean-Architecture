package com.magamal.news.ui.news.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.magamal.news.R
import com.magamal.news.extentions.loadImage
import com.news.presentation.models.news.ArticlePresentation
import kotlinx.android.synthetic.main.item_news.view.*

/**
 * Created by Mahmoud Gamal on 2019-09-07.
 */
class NewsAdapter(private val onItemClicked: (ArticlePresentation) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    val items= ArrayList<ArticlePresentation>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items.get(position).run {
            holder.itemView.apply {
                imgNewsIcon.loadImage(urlToImage)
                tvNewsTitle.text = title
                tvNewsDescription.text = description
            }
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                items.get(adapterPosition).let(onItemClicked)
            }
        }
    }
}