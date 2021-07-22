package com.jacob.amazonproject.presentation.core.callBack

/** Se crea interface llamada "ResultCallBack" la cual nos atrera un mensaje "onSuccess" y "onError".
 * Agregamos un tipo "T" al interface*/
interface ResultCallBack<T> {

    /** Creamos funciones onSuccess y onError para obtener un mensaje*/
    fun onSuccess(type: T)
    fun onError(message: String, type: T? = null)
}