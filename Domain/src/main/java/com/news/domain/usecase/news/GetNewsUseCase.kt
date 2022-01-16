package com.news.domain.usecase.news

import com.news.domain.executor.ObservableUseCase
import com.news.domain.executor.PostExecutionThread
import com.news.domain.executor.SuspendUseCase
import com.news.domain.models.news.News
import com.news.domain.repository.NewsRepository

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
class GetNewsUseCase(
    private val newsRepository: NewsRepository
) : SuspendUseCase<News, GetNewsUseCase.Params>() {

    override suspend fun buildUseCaseSuspend(params: Params?) =
        if (params == null)
            throw IllegalAccessException("Params can't be null")
        else newsRepository
            .getNews(
                page = params.page
                , pageSize = params.pageSize
            )


    data class Params constructor(val page: Int, val pageSize: Int) {
        companion object {
            fun forPage(page: Int, pageSize: Int) =
                Params(page = page, pageSize = pageSize)
        }
    }
}