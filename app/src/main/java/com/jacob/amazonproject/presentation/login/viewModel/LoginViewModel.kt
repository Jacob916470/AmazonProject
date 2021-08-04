package com.jacob.amazonproject.presentation.login.viewModel

import androidx.databinding.ObservableField
import com.jacob.amazonproject.data.local.database.CursoRoomDataBase
import com.jacob.amazonproject.data.local.entities.User
import com.jacob.amazonproject.data.local.repositories.UserRepository
import com.jacob.amazonproject.presentation.core.base.BaseViewModel
import com.jacob.amazonproject.presentation.core.callBack.ResultCallBack
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(
    cursoRoomDataBase: CursoRoomDataBase,
    /** Creamos variable resultCallBack de tipo ResultCallBack agregadole un tipo  de variable "String"*/
    private val resultCallBack: ResultCallBack<User>
): BaseViewModel() {
    val  txtEmailLogin  = ObservableField("")
    val txtPasswordLogin = ObservableField("")

    /** Se crea variable para el repository que accede a la base de datos*/
    private val userRepository = UserRepository(cursoRoomDataBase.userDao())

    fun getLogin(){
        validateLogin()
    }

    private fun validateLogin(){
        job = CoroutineScope(Dispatchers.IO).launch {
            val user = userRepository.getLogin(
                email = txtEmailLogin.get().toString(),password = txtPasswordLogin.get().toString()
            )
            withContext(Dispatchers.Main){
                if (user!=null){
                    resultCallBack.onSuccess(user)
                }else{
                    resultCallBack.onError("E-mail or password inccorect")
                }
            }
        }
    }
}