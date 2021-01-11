package com.news.presentation.mapper.news

import com.news.domain.models.news.Source
import com.news.presentation.mapper.PresentationMapper
import com.news.presentation.models.news.SourcePresentation

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
class SourcePresentationMapper : PresentationMapper<Source, SourcePresentation> {
    override fun mapToPresentation(domain: Source?): SourcePresentation {
        return SourcePresentation(
            id = domain?.id,
            name = domain?.id
        )
    }
}