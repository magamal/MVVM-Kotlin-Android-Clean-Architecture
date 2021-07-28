package com.news.presentation.viewmodels

import androidx.lifecycle.LifecycleOwner
import com.news.domain.usecase.news.GetNewsUseCase
import com.news.presentation.base.BaseViewModel
import com.news.presentation.base.MutableListLiveData
import com.news.presentation.mapper.news.NewsPresentationMapper
import com.news.presentation.models.news.ArticlePresentation
import io.reactivex.rxjava3.kotlin.subscribeBy

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

        addDisposale(
            getNewsUseCase
                .getObservable(params)
                .subscribeBy(
                    onNext = { news ->
                        newsMapper.mapToPresentation(news)
                            .articles?.let(newsLiveData::addItems)
                    },
                    onError = { throwable ->
                        throwable.printStackTrace()
                        newsLiveData.error(throwable)
                    }
                )
        )
    }

    fun isLoading() = newsLiveData.isLoadingData()
}