package com.news.remote.network.errorhandler

import io.reactivex.rxjava3.core.Observable

/**
 * Created by Mahmoud Gamal on 4/11/19.
 */
fun <T> Observable<T>.adaptExceptionError(): Observable<T> {
    return onErrorResumeNext(ExceptionHandler<T>())
}
