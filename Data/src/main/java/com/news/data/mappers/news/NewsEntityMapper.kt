package com.news.data.mappers.news

import com.news.data.mappers.EntityMapper
import com.news.data.models.news.NewsEntity
import com.news.domain.models.news.News

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
class NewsEntityMapper(private val articleMapper: ArticleEntityMapper) :
    EntityMapper<NewsEntity, News> {
    override fun mapToDomain(entity: NewsEntity?): News {
        return News(
            articles = entity?.articles?.map {
                articleMapper.mapToDomain(it)
            }, status = entity?.status,
            totalResults = entity?.totalResults
        )
    }

}