package com.magamal.news.ui.news

import androidx.recyclerview.widget.LinearLayoutManager
import com.magamal.news.R
import com.magamal.news.base.BaseFragment
import com.magamal.news.extentions.addEndlessScroll
import com.magamal.news.extentions.hide
import com.magamal.news.extentions.show
import com.magamal.news.ui.news.adapters.NewsAdapter
import com.news.presentation.viewmodels.NewsListViewModel
import kotlinx.android.synthetic.main.fragment_news_list.*
import org.koin.android.ext.android.get

private const val PAGE_SIZE = 20

class NewsListFragment : BaseFragment<NewsListViewModel>() {

    private val newsAdapter by lazy { NewsAdapter() }
    private var page = 1


    override fun getLayoutRes(): Int = R.layout.fragment_news_list

    override fun setupViews() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = newsAdapter
        }
        //setup load more
        newsScrollView.addEndlessScroll(::loadMore)
    }

    override fun setupData() {}

    override fun setupObservers() {
        setupNewsObserver()
    }

    override fun createViewModel(): NewsListViewModel = get()

    private fun setupNewsObserver() {
        viewModel.observeOnNews(this,
            onLoading = {
                progress.show()
            }, onError = { throwable ->
                progress.hide()

            }, onNewData = { newItems, allItems ->
                page++
                progress.hide()
                newsAdapter.addItems(
                    if (newsAdapter.itemCount == 0)
                        allItems
                    else
                        newItems
                )
            })
    }


    private fun loadMore() {
        if (!viewModel.isLoading())
            fetchData()
    }

    override fun fetchData() {
        viewModel.fetchData(page = page, pageSize = PAGE_SIZE)
    }

}
