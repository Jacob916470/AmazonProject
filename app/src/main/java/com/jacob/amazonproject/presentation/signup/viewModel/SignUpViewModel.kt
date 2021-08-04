package com.jacob.amazonproject.presentation.signup.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.jacob.amazonproject.data.database.CursoRoomDataBase
import com.jacob.amazonproject.data.entities.User
import com.jacob.amazonproject.data.repositories.UserRepository
import com.jacob.amazonproject.data.utils.Configuration
import com.jacob.amazonproject.presentation.core.base.BaseViewModel
import com.jacob.amazonproject.presentation.core.callBack.ResultCallBack
import com.jacob.amazonproject.presentation.utils.FieldValidation
import kotlinx.coroutines.*

/** Heredamos de "BaseViewModel"*/
class SignUpViewModel(
    private val cursoRoomDataBase: CursoRoomDataBase,
    /** Creamos variable resultCallBack de tipo ResultCallBack agregadole un tipo  de variable "String"*/
    private val resultCallBack: ResultCallBack<String>
) : BaseViewModel() {
    private val userRepository = UserRepository(cursoRoomDataBase.userDao())
    /**
     * Se crean variables y las igualamos a un ObservableField la cual sera decalarada como vacia.
     * Se crean las variables en el XML del mismo para poder traer la informacion de las cajas de texto
     * */
    val txtName = ObservableField("")
    val txtEmail = ObservableField("")
    val txtPassword = ObservableField("")

    /** Creamos la función privada de inserUser y la igualamos a un GlobalScope para poner lo en una corutina (GlobalScope)*/
    private fun insertUser() {
        /** Reliza un trabajo de una coroutine */
        job = CoroutineScope(Dispatchers.IO).launch {

            val rows = userRepository.insertUser(
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
            /** Termina nuestra coroutine e iniciamos en el hilo principal
             * Cuando llega aqui significa que la coroutine ha terminado...*/
            withContext(Dispatchers.Main) {
                if (rows>0){
                    /** Mandamos a llamar la variable resultCallBack.onSuccess para mandarle un mensaje al usuario.
                     * Este mensaje se implementara en el SignUpFragment */
                    resultCallBack.onSuccess(txtName.get().toString())
                }else{
                    resultCallBack.onError("No se inserto correctamente a la base de datos")
                }
            }
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
                validateUser()
            }
        }

    }

    /** Creamos función "validateUser" la cual accedera a coroutine y despuesd de validar
     *  esa coroutine regresara a nuestro hilo principal */
    private fun validateUser() {
        job = CoroutineScope(Dispatchers.IO).launch{
            val userCount = userRepository.getUserName(txtName.get().toString())
            /** Entra a nuestro hilo principal y se realizara la acción que solicite */
            withContext(Dispatchers.Main){
                if (userCount==0){
                    validations()
                }else{
                    resultCallBack.onError("Ya existe un usuario con ese nombre")
                }
            }
        }
    }

    private fun validations() {
        if (FieldValidation.isPasswordSafe(password = txtPassword.get().toString()) &&
            FieldValidation.isPasswordLengthValid(password = txtPassword.get().toString())){
            /** Mandamos a llamar la funcion insertUser para que guarde la informacón del usuario*/
            insertUser()
        }else{
            resultCallBack.onError("Tu contraseña necesita tener una mayuscula, una minulcula y por lo menos un caracter, y de 8 a 16 digitos")
        }
    }
}
/** data/data/jacob(package del proyecto/database)*/
