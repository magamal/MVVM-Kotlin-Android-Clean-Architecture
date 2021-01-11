package com.news.remote.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {

    var retrofit: Retrofit = createRetrofitInstance()

    private fun createRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(RestApiConstants.BASE_URL)
            .client(createInterceptor())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createInterceptor(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .addInterceptor(ApiKeyInterceptor())
            .build()
    }

    fun <T> create(javaClass: Class<T>): T {
        return retrofit.create(javaClass)
    }
}