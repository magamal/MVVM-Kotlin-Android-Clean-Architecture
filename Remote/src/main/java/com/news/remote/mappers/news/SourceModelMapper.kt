package com.news.remote.mappers.news

import com.news.data.models.news.SourceEntity
import com.news.remote.mappers.ModelMapper
import com.news.remote.models.news.SourceModel

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
class SourceModelMapper() : ModelMapper<SourceModel, SourceEntity> {
    override fun mapFromModel(model: SourceModel?): SourceEntity {
        return SourceEntity(
            id = model?.id,
            name = model?.id
        )
    }
}