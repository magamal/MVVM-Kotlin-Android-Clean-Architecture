package com.news.data.repository.news

import com.news.data.models.news.NewsEntity

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
interface NewsDataStore {
    suspend fun getNews(page: Int, pageSize: Int): NewsEntity
}