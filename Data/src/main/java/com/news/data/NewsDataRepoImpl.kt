package com.news.data

import com.news.data.mappers.news.NewsEntityMapper
import com.news.data.store.news.NewsDataStoreFactory
import com.news.domain.models.news.News
import com.news.domain.repository.NewsRepository

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
class NewsDataRepoImpl(
    private val storeFactory: NewsDataStoreFactory, private val newsMapper: NewsEntityMapper
) : NewsRepository {

    override suspend fun getNews(page: Int, pageSize: Int): News =
        storeFactory
            .getRemote()
            .getNews(page = page, pageSize = pageSize)
            .run(newsMapper::mapToDomain)

}