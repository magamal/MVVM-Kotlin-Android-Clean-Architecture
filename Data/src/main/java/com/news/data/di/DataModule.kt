package com.news.data.di

import com.news.data.NewsDataRepoImpl
import com.news.data.mappers.news.ArticleEntityMapper
import com.news.data.mappers.news.NewsEntityMapper
import com.news.data.mappers.news.SourceEntityMapper
import com.news.data.store.news.NewsDataStoreFactory
import com.news.data.store.news.NewsRemoteDataStore
import com.news.domain.repository.NewsRepository
import org.koin.dsl.module

/**
 * Created by Mahmoud Gamal on 5/25/19.
 */
val dataModule = module {

    factory { NewsEntityMapper(get()) }
    factory { ArticleEntityMapper(get()) }
    factory { SourceEntityMapper() }



    single { NewsRemoteDataStore(get()) }
    single { NewsDataStoreFactory(get()) }
    single<NewsRepository> { NewsDataRepoImpl(get(), get()) }

}