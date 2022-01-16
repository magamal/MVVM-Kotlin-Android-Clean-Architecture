package com.news.data.store.news

import com.news.data.repository.news.NewsDataStore
import com.news.data.repository.news.NewsRemote

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
class NewsRemoteDataStore(private val newsRemote: NewsRemote) : NewsDataStore {

    override suspend fun getNews(page: Int, pageSize: Int) =
        newsRemote
            .getNews(page = page, pageSize = pageSize)

}