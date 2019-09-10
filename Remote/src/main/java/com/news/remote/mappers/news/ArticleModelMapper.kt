package com.news.remote.mappers.news

import com.news.data.models.news.ArticleEntity
import com.news.remote.mappers.ModelMapper
import com.news.remote.models.news.ArticleModel

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
class ArticleModelMapper(private val sourceMapper: SourceModelMapper) :
    ModelMapper<ArticleModel, ArticleEntity> {

    override fun mapFromModel(model: ArticleModel?): ArticleEntity {
        return ArticleEntity(
            author = model?.author,
            content = model?.content,
            description = model?.description,
            publishedAt = model?.publishedAt,
            source = sourceMapper.mapFromModel(model = model?.source),
            title = model?.title,
            url = model?.url,
            urlToImage = model?.urlToImage
        )
    }
}