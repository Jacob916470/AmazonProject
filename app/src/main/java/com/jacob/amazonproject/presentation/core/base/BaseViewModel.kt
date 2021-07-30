package com.jacob.amazonproject.presentation.core.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

open class BaseViewModel: ViewModel(){

    var job: Job? = null

    override fun onCleared() {
        super.onCleared()
        /** Limpia todas nuestrras corutinas*/
        job?.cancel()
    }
}