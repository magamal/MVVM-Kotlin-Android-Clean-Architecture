package com.news.remote.mappers.news

import com.news.data.models.news.NewsEntity
import com.news.remote.mappers.ModelMapper
import com.news.remote.models.news.NewsResponseModel

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
class NewsResponseModelMapper(private val articleMapper: ArticleModelMapper) :
    ModelMapper<NewsResponseModel, NewsEntity> {

    override fun mapFromModel(model: NewsResponseModel?): NewsEntity {
        return NewsEntity(
            articles = model?.articles?.map {
                articleMapper.mapFromModel(it)
            }, status = model?.status,
            totalResults = model?.totalResults
        )
    }
}