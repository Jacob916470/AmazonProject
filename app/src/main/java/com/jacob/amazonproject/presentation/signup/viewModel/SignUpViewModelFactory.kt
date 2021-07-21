package com.jacob.amazonproject.presentation.signup.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jacob.amazonproject.data.database.CursoRoomDataBase
import com.jacob.amazonproject.presentation.core.callBack.ResultCallback

class SignUpViewModelFactory(
    private val cursoRoomDataBase: CursoRoomDataBase,
    private val resultCallback: ResultCallback<String>
    ) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SignUpViewModel(
            cursoRoomDataBase,
            resultCallback
        ) as T
    }
}