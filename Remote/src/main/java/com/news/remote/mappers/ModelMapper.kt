package com.news.remote.mappers

import com.news.data.models.Entity
import com.news.remote.models.RemoteModel


/**
 * This interface is used when you want to create a new Mapper
 * @M : is for Entity model (in remote layer)
 * @E : is for request model (in clientInfo layer)
 */
interface ModelMapper<M : RemoteModel, E : Entity> {
    fun mapFromModel(model: M?): E
}