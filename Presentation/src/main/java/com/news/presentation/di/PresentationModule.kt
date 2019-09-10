package com.news.presentation.di


import com.news.domain.executor.PostExecutionThread
import com.news.presentation.PostExecutionThreadImp
import com.news.presentation.mapper.news.ArticlePresentationMapper
import com.news.presentation.mapper.news.NewsPresentationMapper
import com.news.presentation.mapper.news.SourcePresentationMapper
import com.news.presentation.viewmodels.NewsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Mahmoud Gamal on 5/25/19.
 */
val presentationModule = module {

    single<PostExecutionThread> { PostExecutionThreadImp() }


    factory { NewsPresentationMapper(get()) }
    factory { ArticlePresentationMapper(get()) }
    factory { SourcePresentationMapper() }


    viewModel { NewsListViewModel(get(),get()) }
}