package com.news.remote.network.errorhandler

import com.google.gson.JsonSyntaxException
import com.magamal.common.AppException
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.Function
import retrofit2.HttpException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


/**
 * Created by Mahmoud Gamal on 4/11/19.
 */
class ExceptionHandler<T> : Function<Throwable, Observable<T>> {
    override fun apply(t: Throwable): Observable<T> {
        return Observable.error(adapt(t))
    }

    private fun adapt(throwable: Throwable): Throwable {
        if (throwable is AppException)
            return throwable
        if (throwable is UnknownHostException || throwable is SocketException || throwable is SocketTimeoutException) {
            return AppException(AppException.ExceptionType.NETWORK, throwable)
        } else if (throwable is JsonSyntaxException)
            return AppException(AppException.ExceptionType.PARSING, throwable)
        else if (throwable is HttpException)
            return getHttpExceptionType(throwable)
        return AppException(AppException.ExceptionType.UNKNOWN, throwable)
    }

    private fun getHttpExceptionType(exception: HttpException): Exception {
        if (exception.code() == UNAUTHORIZED_CODE) {
            return AppException(AppException.ExceptionType.UNAUTHORIZED, exception)
        }

        return AppException(AppException.ExceptionType.UNKNOWN, exception)

    }

    companion object {
        const val UNAUTHORIZED_CODE = 401
        const val NOT_FOUND_CODE = 404
        const val INTERNAL_ERROR_CODE = 505
    }
}