package cz.verunka.droid.ghibliki.services.utils

import android.content.ContentValues
import android.util.Log
import com.google.gson.GsonBuilder
import cz.verunka.droid.ghibliki.services.api.ApiError
import retrofit2.Response
import java.io.IOException

object ApiErrorUtils {

    fun parseError(response: Response<*>): ApiError {

        val gson = GsonBuilder().create()
        val error: ApiError

        try {
            error = gson.fromJson(response.errorBody()?.string(), ApiError::class.java)
        } catch (e: IOException) {
            e.message?.let { Log.d(ContentValues.TAG, it) }
            return ApiError()
        }
        return error
    }
}

object ApiUtils {

    fun <T: Any> handleApiError(response: Response<T>): AppResult.Error {

        val error = ApiErrorUtils.parseError(response)
        return AppResult.Error(Exception(error.message))
    }

    fun <T: Any> handleSuccess(response: Response<T>): AppResult<T> {

        response.body()?.let {
            return AppResult.Success(it)
        } ?: return handleApiError(response)
    }
}