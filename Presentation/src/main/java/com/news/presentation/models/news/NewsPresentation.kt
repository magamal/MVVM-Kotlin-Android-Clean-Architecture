package com.news.presentation.models.news

import com.news.presentation.models.PresentationModel

data class NewsPresentation(
    val articles: List<ArticlePresentation>?,
    val status: String?,
    val totalResults: Int?
) : PresentationModel