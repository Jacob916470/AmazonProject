package com.jacob.amazonproject.presentation.utils

import com.jacob.amazonproject.data.utils.Configuration

object FieldValidation {

    private val passwordPattern = Regex(Configuration.PASSWORD_PATTERN)

    /** Nos dice si cumple con el Regex que le pasamos */
    fun isPasswordSafe(password:String) : Boolean = password.contains(passwordPattern)

    fun isPasswordLengthValid(password: String) : Boolean{
        return password.length in Configuration.MIN_PASSWORD_LENGTH..Configuration.MAX_PASSWORD_LENGTH
    }
}