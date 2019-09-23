package com.news.presentation.viewmodels

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.news.domain.usecase.news.GetNewsUseCase
import com.news.presentation.base.BaseViewModel
import com.news.presentation.base.Resource
import com.news.presentation.mapper.news.NewsPresentationMapper
import com.news.presentation.models.news.NewsPresentation
import io.reactivex.rxkotlin.subscribeBy

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
class NewsListViewModel(
    private val getNewsUseCase: GetNewsUseCase,
    private val newsMapper: NewsPresentationMapper
) : BaseViewModel() {

    private var page = 1
    private val newsLiveData = MutableLiveData<Resource<NewsPresentation>>()

    fun observeOnNews(
        lifecycleOwner: LifecycleOwner,
        observer: Observer<Resource<NewsPresentation>>
    ) {
        newsLiveData.observe(lifecycleOwner, observer)
    }

    fun fetchData() {
        newsLiveData.value = Resource.loading()
        val params = GetNewsUseCase.Params.forPage(page, PAGE_SIZE)

        addDisposale(
            getNewsUseCase
                .getObservable(params)
                .subscribeBy(
                    onNext = { news ->
                        newsLiveData.postValue(Resource.success(newsMapper.mapToPresentation(news)))
                        page++
                    },
                    onError = { t ->
                        t.printStackTrace()
                        newsLiveData.postValue(Resource.error(t))
                    }
                )
        )
    }

    fun loadMore() {
        if (!isLoading())
            fetchData()
    }

    private fun isLoading() =
        newsLiveData.value != null && newsLiveData.value!!.state == Resource.State.LOADING


    companion object {
        private const val PAGE_SIZE = 20
    }
}