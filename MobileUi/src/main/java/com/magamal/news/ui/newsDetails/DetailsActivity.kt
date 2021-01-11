package com.magamal.news.ui.newsDetails

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.magamal.news.R
import com.magamal.news.extentions.loadImage
import com.magamal.news.extentions.show
import com.news.presentation.models.news.ArticlePresentation
import kotlinx.android.synthetic.main.activity_details.*


class DetailsActivity : AppCompatActivity() {

    private lateinit var article: ArticlePresentation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        if (!intent.hasExtra(ARTICLE_ARG)) {
            finish()
            return
        }
        article = intent.getParcelableExtra(ARTICLE_ARG)
        article.run {
            imgNewsIcon.loadImage(urlToImage)
            tvNewsTitle.text = title
            tvContent.text = content
            tvDate.text = getFormattedDate()
            source?.name?.let {
                tvSource.show()
                tvSource.text = it
                tvSource.setOnClickListener { onSourceClicked() }
            }
        }
    }

    private fun onSourceClicked() {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(article.url)))
    }


    companion object {

        private const val ARTICLE_ARG = "article_arg"

        fun getIntentForArticle(context: Context, article: ArticlePresentation) =
            Intent(context, DetailsActivity::class.java)
                .putExtra(ARTICLE_ARG, article)

    }
}
