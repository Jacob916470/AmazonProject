package com.jacob.amazonproject.data.utils

class Configuration {

    companion object{
        const val PASSWORD_PATTERN = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!\"#\$%&/()=<>+\\-@?_':;])"
        const val MIN_PASSWORD_LENGTH = 8
        const val MAX_PASSWORD_LENGTH = 16
    }
}