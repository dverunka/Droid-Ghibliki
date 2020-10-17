package cz.verunka.droid.ghibliki.services.utils

import java.lang.Exception

/**
 * Wrapper class that helps to handle success and failure scenarios with coroutines.
 */
sealed class AppResult<out T> {

    data class Success<out T>(val successData : T) : AppResult<T>()

    class Error(val exception: Exception, val message: String = exception.localizedMessage) : AppResult<Nothing>()
}