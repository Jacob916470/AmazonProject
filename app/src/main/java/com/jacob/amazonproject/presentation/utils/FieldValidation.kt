package com.jacob.amazonproject.presentation.utils

import com.jacob.amazonproject.data.utils.Configurations

/** Creamos "object FieldValidation" para poder utilizar Regex*/
object FieldValidation {

    /** Creamos private val "passwordPattern" para poder hacer validaciones del password.
     * Se iguala a Regex y en su constructor atrar la clase "Configuration", y atraemos la variable "PASSWORD_PATTERN" que
     * atrae la configuración deseada*/
    private val passwordPattern = Regex(Configurations.PASSWORD_PATTERN)

    /** Nos dice si cumple con el Regex que le pasamos */
    fun isPasswordSafe(password:String) : Boolean = password.contains(passwordPattern)

    fun isPasswordLengthValid(password: String) : Boolean{
        /** Valida la longitud de nustro password*/
        return password.length in Configurations.MIN_PASSWORD_LENGTH..Configurations.MAX_PASSWORD_LENGTH
    }
}
