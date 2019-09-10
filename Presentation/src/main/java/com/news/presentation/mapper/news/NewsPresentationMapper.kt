package com.news.presentation.mapper.news

import com.news.domain.models.news.News
import com.news.presentation.mapper.PresentationMapper
import com.news.presentation.models.news.NewsPresentation

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
class NewsPresentationMapper(private val articleMapper: ArticlePresentationMapper) :
    PresentationMapper<News,NewsPresentation> {
    override fun mapToPresentation(domain: News?): NewsPresentation {
        return NewsPresentation(
            articles = domain?.articles?.map {
                articleMapper.mapToPresentation(it)
            }, status = domain?.status,
            totalResults = domain?.totalResults
        )
    }
}