package com.news.data.mappers.news

import com.news.data.mappers.EntityMapper
import com.news.data.models.news.ArticleEntity
import com.news.domain.models.news.Article

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
class ArticleEntityMapper(private val sourceMapper: SourceEntityMapper) :
    EntityMapper<ArticleEntity, Article> {
    override fun mapToDomain(entity: ArticleEntity?): Article {
        return Article(
            author = entity?.author,
            content = entity?.content,
            description = entity?.description,
            publishedAt = entity?.publishedAt,
            source = sourceMapper.mapToDomain(entity = entity?.source),
            title = entity?.title,
            url = entity?.url,
            urlToImage = entity?.urlToImage
        )
    }
}