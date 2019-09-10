package com.news.remote

import com.news.data.repository.news.NewsRemote
import com.news.remote.mappers.news.NewsResponseModelMapper
import com.news.remote.service.NewsService

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
class NewsRetrofitRemoteRepo(
    private val newsService: NewsService
    , private val newsMapper: NewsResponseModelMapper
) : NewsRemote {

    override fun getNews(page: Int, pageSize: Int) =
        newsService
            .getNews(page = page, pageSize = pageSize)
            .map {
                newsMapper.mapFromModel(model = it)
            }

}