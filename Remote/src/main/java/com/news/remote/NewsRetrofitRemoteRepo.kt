package com.news.remote

import com.news.data.models.news.NewsEntity
import com.news.data.repository.news.NewsRemote
import com.news.remote.mappers.news.NewsResponseModelMapper
import com.news.remote.service.NewsService
import io.reactivex.rxjava3.core.Observable

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
class NewsRetrofitRemoteRepo(
    private val newsService: NewsService,
    private val newsMapper: NewsResponseModelMapper
) : NewsRemote {

   override suspend fun getNews(page: Int, pageSize: Int): NewsEntity =
        newsService
            .getNews(page = page, pageSize = pageSize)
            .run (newsMapper::mapFromModel)
}