package com.magamal.news.ui.news.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.magamal.news.R
import com.magamal.news.extentions.loadImage
import com.magamal.news.ui.newsDetails.DetailsActivity
import com.news.presentation.models.news.ArticlePresentation
import kotlinx.android.synthetic.main.item_news.view.*

/**
 * Created by Mahmoud Gamal on 2019-09-07.
 */
class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val items = ArrayList<ArticlePresentation>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_news, parent, false)
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items[position].run {
            holder.itemView.apply {
                imgNewsIcon.loadImage(urlToImage)
                tvNewsTitle.text = title
                tvNewsDescription.text = description
            }
        }
    }

    fun addItems(items: List<ArticlePresentation>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                if (adapterPosition >= 0)
                    items[adapterPosition].let(::onArticleClicked)
            }
        }

        private fun onArticleClicked(article: ArticlePresentation) {
            itemView.context?.let { context ->
                context.startActivity(DetailsActivity.getIntentForArticle(context, article))
            }
        }
    }
}