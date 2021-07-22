package com.jacob.amazonproject.presentation.signup.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.jacob.amazonproject.data.database.CursoRoomDataBase
import com.jacob.amazonproject.data.entities.User
import com.jacob.amazonproject.data.repositories.UserRepository
import com.jacob.amazonproject.presentation.core.callBack.ResultCallback
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignUpViewModel(
    private val cursoRoomDataBase: CursoRoomDataBase,
    /** Creamos variable resultCallBack de tipo ResultCallBack agregadole un tipo  de variable "String"*/
    private val resultCallBack: ResultCallback<String>
) : ViewModel() {
    private val userRepository = UserRepository(cursoRoomDataBase.userDao())

    /**
     * Se crean variables y las igualamos a un ObservableField la cual sera decalarada como vacia.
     * Se crean las variables en el XML del mismo para poder traer la informacion de las cajas de texto
     * */
    val txtName = ObservableField("")
    val txtEmail = ObservableField("")
    val txtPassword = ObservableField("")

    /** Creamos la función privada de inserUser y la igualamos a un GlobalScope para poner lo en una corutina */
    private fun insertUser() = GlobalScope.launch {
        userRepository.insertUser(
            /** Mandamos a llamar los campos de la tabla que creamos y las igualamos a las variables
             * que se crearon para obtener la información de las cajas de texto */
            user = User(
                name = txtName.get().toString(),
                age = 23,
                mail = txtEmail.get().toString(),
                password = txtPassword.get().toString(),
                autoAccept = true
            )
        )
        /**  */
        withContext(Dispatchers.Main) {
            /** Mandamos a llamar la variable resultCallBack.onSuccess para mandarle un mensaje al usuario.
             * Este mensaje se implementara en el SignUpFragment */
            resultCallBack.onSuccess(txtName.get().toString())
        }
    }

    /** Creamos función saveUser para guardar los datos del usuario, la cual sera llamada a nuestro SignUpFragment.*/
    fun saveUser() {
        /** Agregamos el bucle "when" para declarar los casos a occurir en caso de campos vacios
         * (mandamos a llamar la variable resultCallBack.onError para agregar un String con el error según sea el caso)*/
        when {
            txtName.get().toString().isEmpty() -> {
                resultCallBack.onError("Necesitamos saber tu nombre")
            }
            txtEmail.get().toString().isEmpty() -> {
                resultCallBack.onError("Necesitamos saber tu e-mal")
            }
            txtPassword.get().toString().isEmpty() -> {
                resultCallBack.onError("Necesitamos una contraseñapara tu cuenta")
            }
            else -> {
                /** Mandamos a llamar la funcion insertUser para que guarde la informacón del usuario*/
                insertUser()
            }
        }

    }
}
/** data/data/jacob(package del proyecto/database)*/
