package com.news.data.mappers.news

import com.news.data.mappers.EntityMapper
import com.news.data.models.news.SourceEntity
import com.news.domain.models.news.Source

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
class SourceEntityMapper() : EntityMapper<SourceEntity, Source> {
    override fun mapToDomain(entity: SourceEntity?): Source {
        return Source(
            id = entity?.id,
            name = entity?.id
        )
    }
}