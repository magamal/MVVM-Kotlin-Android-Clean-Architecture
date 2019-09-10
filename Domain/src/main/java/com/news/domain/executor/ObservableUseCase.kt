package com.news.domain.executor

import com.news.domain.models.DomainModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

abstract class ObservableUseCase<T : DomainModel, in E>(private val schedulerThread: PostExecutionThread) {

    abstract fun buildUseCaseObservable(params: E? = null): Observable<T>

    fun getObservable(params: E? = null): Observable<T> {
        return buildUseCaseObservable(params)
            .subscribeOn(Schedulers.io())
            .observeOn(schedulerThread.scheduler)
    }


}