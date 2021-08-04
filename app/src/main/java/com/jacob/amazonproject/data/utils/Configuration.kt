package com.jacob.amazonproject.data.utils

class Configuration {

    /** Creamos un companion object para declarar constantes las cuales tendran la configuración  de nuestras validaciones*/
    companion object{
        const val PASSWORD_PATTERN = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!\"#\$%&/()=<>+\\-@?_':;])"
        const val MIN_PASSWORD_LENGTH = 8
        const val MAX_PASSWORD_LENGTH = 16
    }
}