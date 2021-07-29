package com.jacob.amazonproject.presentation.login.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.jacob.amazonproject.data.database.CursoRoomDataBase
import com.jacob.amazonproject.data.entities.User
import com.jacob.amazonproject.presentation.core.callBack.ResultCallBack

class LoginViewModel(
    private val cursoRoomDataBase: CursoRoomDataBase,
    /** Creamos variable resultCallBack de tipo ResultCallBack agregadole un tipo  de variable "String"*/
    private val resultCallBack: ResultCallBack<User>
): ViewModel() {
    val  txtEmailLogin  = ObservableField("")
    val txtPasswordLogin = ObservableField("")

    fun getLogin(){

    }
}