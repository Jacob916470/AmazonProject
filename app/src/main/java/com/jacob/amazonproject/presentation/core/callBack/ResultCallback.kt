package com.jacob.amazonproject.presentation.core.callBack

interface ResultCallback<T> {

    /** Creamos funciones onSuccess y onError para obtener un mensaje*/
    fun onSuccess(type: T)
    fun onError(message: String, type: T? = null)

}