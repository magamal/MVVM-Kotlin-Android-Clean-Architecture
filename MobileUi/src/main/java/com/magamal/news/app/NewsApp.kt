package com.magamal.news.app

import android.app.Application
import com.news.data.di.dataModule
import com.news.domain.di.domainModule
import com.news.presentation.di.presentationModule
import com.news.remote.di.remoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
class NewsApp : Application() {

    override fun onCreate() {
        super.onCreate()

        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@NewsApp)
            modules(listOf(presentationModule, domainModule, dataModule, remoteModule))
        }
    }
}