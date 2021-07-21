package com.jacob.amazonproject.presentation.core.callBack

interface ResultCallback<T> {

    fun onSuccess(type: T)
    fun onError(message: String, type: T? = null)

}