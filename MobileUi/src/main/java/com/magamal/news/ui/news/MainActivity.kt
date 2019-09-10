package com.magamal.news.ui.news

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.magamal.news.R
import com.magamal.news.extentions.addEndlessScroll
import com.magamal.news.ui.news.adapters.NewsAdapter
import com.magamal.news.ui.newsDetails.DetailsActivity
import com.news.presentation.base.Resource
import com.news.presentation.models.news.ArticlePresentation
import com.news.presentation.models.news.NewsPresentation
import com.news.presentation.viewmodels.NewsListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: NewsListViewModel by viewModel()
    private val newsAdapter by lazy { NewsAdapter(::onArticleClicked) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initObservers()
        fetchData(savedInstanceState)
    }

    private fun fetchData(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) { // if null then it is the first time
            viewModel.fetchData()
        }
    }

    private fun initObservers() {
        viewModel.observeOnNews(this, Observer(::onNewsRetrieved))
    }

    private fun onNewsRetrieved(resource: Resource<NewsPresentation>?) {
        resource?.let { (news, state, error) ->
            when (state) {
                Resource.State.LOADING -> {
                    progress.visibility = View.VISIBLE
                }
                Resource.State.SUCCESS -> {
                    progress.visibility = View.GONE
                    news?.let {
                        it.articles?.let {
                            newsAdapter.items?.addAll(it)
                            newsAdapter.notifyDataSetChanged()
                        }
                    }
                }
                Resource.State.ERROR -> {
                    progress.visibility = View.GONE
                    Snackbar.make(viewNewsList, R.string.network_error, Snackbar.LENGTH_INDEFINITE)
                        .setAction(R.string.retry) {
                            fetchData(null)
                        }
                        .show()
                }
            }

        }
    }

    private fun initView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = newsAdapter
        }

        //setup load more
        newsScrollView.addEndlessScroll { viewModel.loadMore() }

    }

    private fun onArticleClicked(article: ArticlePresentation) {
        startActivity(DetailsActivity.getIntentForArticle(this,article))
    }


}
