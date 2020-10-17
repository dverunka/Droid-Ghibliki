package cz.verunka.droid.ghibliki.services.repo

import android.content.Context
import cz.verunka.droid.ghibliki.db.dao.MoviesDAO
import cz.verunka.droid.ghibliki.db.dao.PersonsDAO
import cz.verunka.droid.ghibliki.db.model.Movie
import cz.verunka.droid.ghibliki.db.model.Person
import cz.verunka.droid.ghibliki.services.api.GhibliApi
import cz.verunka.droid.ghibliki.services.extensions.noNetworkConnectivityError
import cz.verunka.droid.ghibliki.services.utils.ApiUtils.handleApiError
import cz.verunka.droid.ghibliki.services.utils.ApiUtils.handleSuccess
import cz.verunka.droid.ghibliki.services.utils.AppResult
import cz.verunka.droid.ghibliki.services.utils.NetworkManager.isOnline
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GhibliRepository(
    private val api: GhibliApi,
    private val context: Context,
    private val moviesDAO: MoviesDAO,
    private val personsDAO: PersonsDAO

) : IGhibliRepository {

    override suspend fun getAllMovies(): AppResult<List<Movie>> {

        if (isOnline(context)) {
            return try {
                val response = api.getAllMovies()

                if (response.isSuccessful) {
                    // save data
                    response.body()?.let {
                        withContext(Dispatchers.IO) { moviesDAO.addAll(it) }
                    }
                    handleSuccess(response)
                } else {
                    handleApiError(response)
                }
            } catch (e: Exception) {
                AppResult.Error(e)
            }
        } else {
            // check if data exist in database
            val data = getMoviesFromCache()

            return if (data.isNotEmpty()) {
                AppResult.Success(data)
            } else {
                context.noNetworkConnectivityError()
            }
        }
    }

    override suspend fun getAllPersons(): AppResult<List<Person>> {

        if (isOnline(context)) {
            return try {
                val response = api.getAllPersons()

                if (response.isSuccessful) {
                    // save data
                    response.body()?.let {
                        withContext(Dispatchers.IO) { personsDAO.addAll(it) }
                    }
                    handleSuccess(response)
                } else {
                    handleApiError(response)
                }
            } catch (e: Exception) {
                AppResult.Error(e)
            }
        } else {
            // check if data exist in database
            val data = getPersonsFromCache()

            return if (data.isNotEmpty()) {
                AppResult.Success(data)
            } else {
                context.noNetworkConnectivityError()
            }
        }
    }

    /**
     * Returns movies data from local database.
     */
    private suspend fun getMoviesFromCache(): List<Movie> {
        return withContext(Dispatchers.IO) {
            moviesDAO.getAll()
        }
    }

    /**
     * Returns persons data from local database.
     */
    private suspend fun getPersonsFromCache(): List<Person> {
        return withContext(Dispatchers.IO) {
            personsDAO.getAll()
        }
    }
}