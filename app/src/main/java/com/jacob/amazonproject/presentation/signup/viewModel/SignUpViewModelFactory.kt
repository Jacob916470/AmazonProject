package com.jacob.amazonproject.presentation.signup.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jacob.amazonproject.data.database.CursoRoomDataBase

class SignUpViewModelFactory(
    private val cursoRoomDataBase: CursoRoomDataBase
    ) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SignUpViewModel(cursoRoomDataBase) as T
    }
}