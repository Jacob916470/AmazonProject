package com.jacob.amazonproject.presentation.signup.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.jacob.amazonproject.data.database.CursoRoomDataBase
import com.jacob.amazonproject.data.entities.User
import com.jacob.amazonproject.data.repositories.UserRepository
import com.jacob.amazonproject.presentation.core.callBack.ResultCallback
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class SignUpViewModel(
    private val cursoRoomDataBase: CursoRoomDataBase,
    private val resultCallback: ResultCallback<String>
): ViewModel() {
    private val userRepository = UserRepository(cursoRoomDataBase.userDao())

    val txtName = ObservableField("")
    val txtEmail = ObservableField("")
    val txtPassword = ObservableField("")


    private fun insertUser() = GlobalScope.launch {
        userRepository.insertUser(
            user = User(
                name = txtName.get().toString(),
                age = 23,
                mail = txtEmail.get().toString(),
                password = txtPassword.get().toString(),
                autoAccept = true
            )
        )
        withContext(Dispatchers.Main) {
            resultCallback.onSuccess(txtName.get().toString())
        }
    }

    fun saveUser() {
        when {
            txtName.get().toString().isEmpty() -> {
                resultCallback.onError("Necesitamos saber tu nombre")
            }
            txtEmail.get().toString().isEmpty() -> {
                resultCallback.onError("Necesitamos saber tu e-mail")
            }
            txtPassword.get().toString().isEmpty() -> {
                resultCallback.onError("Necesitamos una contraseña para tu cuenta")
            }
            else -> {
                insertUser()
            }
        }
    }

}
/** data/data/jacob(package del proyecto/database)*/
