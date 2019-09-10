package com.news.data.models.news


import com.news.data.models.Entity

data class NewsEntity(
    val articles: List<ArticleEntity>?,
    val status: String?,
    val totalResults: Int?
) : Entity