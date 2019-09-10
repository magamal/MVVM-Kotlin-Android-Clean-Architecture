package com.news.data.mappers

import com.news.data.models.Entity
import com.news.domain.models.DomainModel

/**
 * This interface is used when you want to create a new Mapper
 * @E : is for Entity model (in data layer)
 * @D : is for Domain model
 */
interface EntityMapper<E : Entity, D : DomainModel> {
    fun mapToDomain(entity: E?): D // to Domain (Domain Module)
}