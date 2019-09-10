package com.news.presentation.mapper

import com.news.domain.models.DomainModel
import com.news.presentation.models.PresentationModel

/**
 * This interface is used when you want to create a new Mapper
 * @E : is for Entity model (in clientInfo layer)
 * @D : is for Domain model
 */
interface PresentationMapper<D : DomainModel, V : PresentationModel> {
    fun mapToPresentation(domain: D?): V
}