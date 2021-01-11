package com.news.domain.repository

import com.news.domain.models.news.News
import io.reactivex.rxjava3.core.Observable

/**
 * Created by Mahmoud Gamal on 2019-06-03.
 */
interface NewsRepository {
    fun getNews(page: Int, pageSize: Int): Observable<News>
}