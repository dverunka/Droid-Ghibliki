package cz.verunka.droid.ghibliki.db

import androidx.room.Database
import androidx.room.RoomDatabase
import cz.verunka.droid.ghibliki.db.dao.MoviesDAO
import cz.verunka.droid.ghibliki.db.model.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {

    abstract val moviesDao: MoviesDAO
}