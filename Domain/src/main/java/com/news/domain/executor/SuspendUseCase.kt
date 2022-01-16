package com.news.domain.executor

import com.news.domain.models.DomainModel

/**
 * @author Mahmoud Gamal on 28/07/2021.
 */
abstract class SuspendUseCase<T : DomainModel, in E> {

    protected abstract suspend fun buildUseCaseSuspend(params: E? = null): T

    suspend fun getData(params: E? = null): T = buildUseCaseSuspend(params)
}