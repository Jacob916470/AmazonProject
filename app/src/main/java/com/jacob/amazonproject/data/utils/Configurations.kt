package com.jacob.amazonproject.data.utils

class Configurations {

    /** Creamos un companion object para declarar constantes las cuales tendran la configuración  de nuestras validaciones*/
    companion object{
        const val PASSWORD_PATTERN = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!\"#\$%&/()=<>+\\-@?_':;])"
        const val MIN_PASSWORD_LENGTH = 8
        const val MAX_PASSWORD_LENGTH = 16
        const val MOVIE_API_KEY = "1f54bd990f1cdfb230adb312546d765d"
        const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
    }

    private val currentConfiguration = "dev"
    private val configuration = mapOf(
        "dev" to Configuration(
            baseURL = "https://api.themoviedb.org/3/"
        ),
        "qa" to Configuration(
            baseURL = "https://api.themoviedb.org/3/"
        ),
        "release" to Configuration(
            baseURL = "https://api.themoviedb.org/3/"
        )
    )
    private var baseURL: String = ""

    init {
        val selectConfig = configuration[currentConfiguration]
        selectConfig?.baseURL?.let { baseURL = it }
    }

    fun getBaseURL(): String = baseURL
}

private data class Configuration(
    val baseURL : String = ""
)