package com.news.presentation.viewmodels

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewModelScope
import com.news.domain.usecase.news.GetNewsUseCase
import com.news.presentation.base.BaseViewModel
import com.news.presentation.base.MutableListLiveData
import com.news.presentation.mapper.news.NewsPresentationMapper
import com.news.presentation.models.news.ArticlePresentation
import kotlinx.coroutines.launch

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
class NewsListViewModel(
    private val getNewsUseCase: GetNewsUseCase,
    private val newsMapper: NewsPresentationMapper
) : BaseViewModel() {

    private val newsLiveData = MutableListLiveData<ArticlePresentation>()

    fun observeOnNews(
        owner: LifecycleOwner,
        onLoading: () -> Unit,
        onError: (Throwable?) -> Unit,
        onNewData: (List<ArticlePresentation>, List<ArticlePresentation>) -> Unit

    ) = newsLiveData.observe(owner, onLoading, onError, onNewData)


    fun fetchData(page: Int, pageSize: Int) {
        newsLiveData.loading()
        val params = GetNewsUseCase.Params.forPage(page, pageSize)


        viewModelScope.launch {
            try {
                val news = getNewsUseCase.getData(params)
                newsLiveData.addItems(newsMapper.mapToPresentation(news).articles)
            } catch (e: Exception) {
                e.printStackTrace()
                newsLiveData.error(e)
            }
        }
    }

    fun isLoading() = newsLiveData.isLoadingData()
}