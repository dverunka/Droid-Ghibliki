package cz.verunka.droid.ghibliki.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cz.verunka.droid.ghibliki.db.model.Movie

@Dao
interface MoviesDAO {

    @Query("SELECT * FROM Movies")
    fun getAll(): List<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(movies: List<Movie>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(movie: Movie)
}