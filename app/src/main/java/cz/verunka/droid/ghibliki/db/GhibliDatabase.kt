package cz.verunka.droid.ghibliki.db

import androidx.room.Database
import androidx.room.RoomDatabase
import cz.verunka.droid.ghibliki.db.dao.MoviesDAO
import cz.verunka.droid.ghibliki.db.dao.PersonsDAO
import cz.verunka.droid.ghibliki.db.model.Movie
import cz.verunka.droid.ghibliki.db.model.Person

@Database(entities = [Movie::class, Person::class], version = 4, exportSchema = false)
abstract class GhibliDatabase : RoomDatabase() {

    abstract val moviesDao: MoviesDAO

    abstract val personsDAO: PersonsDAO
}