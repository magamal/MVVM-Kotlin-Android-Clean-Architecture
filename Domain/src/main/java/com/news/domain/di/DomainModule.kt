package com.news.domain.di

import com.news.domain.usecase.news.GetNewsUseCase
import org.koin.dsl.module

/**
 * Created by Mahmoud Gamal on 5/25/19.
 */
val domainModule = module {

    factory { GetNewsUseCase(get(), get()) }
}