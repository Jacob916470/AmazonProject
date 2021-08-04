package com.jacob.amazonproject.presentation.login.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jacob.amazonproject.data.local.database.CursoRoomDataBase
import com.jacob.amazonproject.data.local.entities.User
import com.jacob.amazonproject.presentation.core.callBack.ResultCallBack

class LoginViewModelFactory(
    private val cursoRoomDataBase: CursoRoomDataBase,
    /** Creamos variable resultCallBack de tipo ResultCallBack agregadole un tipo  de variable "String"*/
    private val resultCallBack: ResultCallBack<User>
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(
            cursoRoomDataBase,
            /** Retornamos la variable resultCallBack, y se implementa en el SignUpViewModel*/
            resultCallBack
        ) as T
    }
}