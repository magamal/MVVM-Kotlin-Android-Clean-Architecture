package com.news.domain.executor

import com.news.domain.models.DomainModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class ObservableUseCase<T : DomainModel, in E>(private val schedulerThread: PostExecutionThread) {

    abstract fun buildUseCaseObservable(params: E? = null): Observable<T>

    fun getObservable(params: E? = null): Observable<T> {
        return buildUseCaseObservable(params)
            .subscribeOn(Schedulers.io())
            .observeOn(schedulerThread.scheduler)
    }


}