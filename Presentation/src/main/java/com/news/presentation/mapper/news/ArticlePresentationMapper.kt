package com.news.presentation.mapper.news

import com.news.domain.models.news.Article
import com.news.presentation.mapper.PresentationMapper
import com.news.presentation.models.news.ArticlePresentation

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
class ArticlePresentationMapper(private val sourceMapper: SourcePresentationMapper) :
    PresentationMapper<Article, ArticlePresentation> {
    override fun mapToPresentation(domain: Article?): ArticlePresentation {
        return ArticlePresentation(
            author = domain?.author,
            content = domain?.content,
            description = domain?.description,
            publishedAt = domain?.publishedAt,
            source = sourceMapper.mapToPresentation(domain = domain?.source),
            title = domain?.title,
            url = domain?.url,
            urlToImage = domain?.urlToImage
        )
    }

}