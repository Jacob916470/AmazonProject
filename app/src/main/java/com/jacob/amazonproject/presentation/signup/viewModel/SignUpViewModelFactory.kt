package com.jacob.amazonproject.presentation.signup.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jacob.amazonproject.data.database.CursoRoomDataBase
import com.jacob.amazonproject.presentation.core.callBack.ResultCallBack

class SignUpViewModelFactory(
    private val cursoRoomDataBase: CursoRoomDataBase,
    /** Creamos variable resultCallBack de tipo ResultCallBack agregadole un tipo  de variable "String"*/
    private val resultCallBack: ResultCallBack<String>
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SignUpViewModel(
            cursoRoomDataBase,
            /** Retornamos la variable resultCallBack, y se implementa en el SignUpViewModel*/
            resultCallBack
        ) as T
    }
}