package com.news.data.repository.news

import com.news.data.models.news.NewsEntity
import io.reactivex.rxjava3.core.Observable

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
interface NewsRemote {
    fun getNews(page: Int, pageSize: Int): Observable<NewsEntity>
}