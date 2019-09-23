package com.news.remote.di

import com.news.data.repository.news.NewsRemote
import com.news.remote.NewsRetrofitRemoteRepo
import com.news.remote.mappers.news.ArticleModelMapper
import com.news.remote.mappers.news.NewsResponseModelMapper
import com.news.remote.mappers.news.SourceModelMapper
import com.news.remote.network.RetrofitClient
import com.news.remote.service.NewsService
import org.koin.dsl.module

/**
 * Created by Mahmoud Gamal on 5/25/19.
 */
val remoteModule = module {

    /**
     * RemoteModel mappers
     */
    factory { NewsResponseModelMapper(get()) }
    factory { ArticleModelMapper(get()) }
    factory { SourceModelMapper() }


    /**
     * Remote repositories
     */
    single<NewsRemote> { NewsRetrofitRemoteRepo(get(), get()) }


    /**
     * Retrofit services
     */
    single { RetrofitClient.create(NewsService::class.java) }

}
