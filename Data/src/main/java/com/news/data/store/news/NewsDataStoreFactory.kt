package com.news.data.store.news

import com.news.data.repository.news.NewsDataStore

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
class NewsDataStoreFactory(private val newsRemoteDataStore: NewsRemoteDataStore) {

    fun getRemote(): NewsDataStore = newsRemoteDataStore

}