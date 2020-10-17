package cz.verunka.droid.ghibliki.services.repo

import cz.verunka.droid.ghibliki.db.model.Movie
import cz.verunka.droid.ghibliki.db.model.Person
import cz.verunka.droid.ghibliki.services.utils.AppResult

interface IGhibliRepository {

    /**
     * Get all movies from API or local database.
     */
    suspend fun getAllMovies(): AppResult<List<Movie>>

    /**
     * Get all persons from API pr local database.
     */
    suspend fun getAllPersons(): AppResult<List<Person>>
}