package com.news.presentation.base

import androidx.lifecycle.MutableLiveData

/**
 * @author Mahmoud Gamal on 1/1/21.
 */
open class MutableResourceLiveData<T> : MutableLiveData<Resource<T>>() {

    fun success(t: T) {
        value = Resource.success(t)
    }

    fun postSuccess(t: T) {
        postValue(Resource.success(t))
    }

    fun error(throwable: Throwable?) {
        value = Resource.error(throwable)
    }

    fun postError(throwable: Throwable?) {
        postValue(Resource.error(throwable))
    }

    fun loading() {
        value = Resource.loading()
    }

    fun postLoading() {
        postValue(Resource.loading())
    }

    fun isLoadingData(): Boolean {
        return !(value == null || value?.state != Resource.State.LOADING)
    }

}