package com.news.presentation.base

/**
 * Created by Mahmoud Gamal on 4/15/19.
 */
data class Resource<T> private constructor(
    val values: T? = null,
    val state: State,
    val throwable: Throwable? = null
) {

    companion object {
        fun <T> success(t: T): Resource<T> {
            return Resource<T>(
                values = t,
                state = State.SUCCESS
            )
        }

        fun <T> error(throwable: Throwable? = null): Resource<T> {
            return Resource<T>(
                state = State.ERROR,
                throwable = throwable
            )
        }

        fun <T> loading(): Resource<T> {
            return Resource<T>(state = State.LOADING)
        }
    }

    enum class State {
        SUCCESS,
        ERROR,
        LOADING
    }


}