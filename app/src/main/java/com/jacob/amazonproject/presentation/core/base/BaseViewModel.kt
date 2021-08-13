package com.jacob.amazonproject.presentation.core.base

import androidx.lifecycle.ViewModel
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.coroutines.Job

/** Creamos un open class "BaseViewModel" y heredamos de ViewModel para poder acceder a las funciones de la clase
 * y mandarlas a llamar a donde se requiera (y asi no crear estas funciones en donde se llegase requerir)*/
open class BaseViewModel: ViewModel(){

    var job: Job? = null

    override fun onCleared() {
        super.onCleared()
        /** Limpia todas nuestrras corutinas*/
        job?.cancel()
    }
}