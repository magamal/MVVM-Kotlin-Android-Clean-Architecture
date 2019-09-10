package com.news.domain.models.news

import com.news.domain.models.DomainModel

data class News(
    val articles: List<Article>?,
    val status: String?,
    val totalResults: Int?
) : DomainModel