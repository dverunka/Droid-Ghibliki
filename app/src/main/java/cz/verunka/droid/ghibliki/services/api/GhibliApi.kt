package cz.verunka.droid.ghibliki.services.api

import cz.verunka.droid.ghibliki.db.model.Movie
import cz.verunka.droid.ghibliki.db.model.Person
import retrofit2.Response
import retrofit2.http.GET

interface GhibliApi {

    @GET("/films")
    suspend fun getAllMovies(): Response<List<Movie>>

    @GET("/people")
    suspend fun getAllPersons(): Response<List<Person>>
}