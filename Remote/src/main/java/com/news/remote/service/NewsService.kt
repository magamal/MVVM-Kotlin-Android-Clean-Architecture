package com.news.remote.service

import com.news.remote.models.news.NewsResponseModel
import com.news.remote.network.RestApiConstants
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
interface NewsService {

    @GET(RestApiConstants.GET_NEWS_END_POINT)
    suspend fun getNews(
        @Query(RestApiConstants.PAGE_SIZE_PARAMS) pageSize: Int,
        @Query(RestApiConstants.PAGE_PARAMS) page: Int
    ): NewsResponseModel
}