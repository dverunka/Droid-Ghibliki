package cz.verunka.droid.ghibliki.db

import androidx.room.Database
import androidx.room.RoomDatabase
import cz.verunka.droid.ghibliki.db.dao.PersonsDAO
import cz.verunka.droid.ghibliki.db.model.Person

@Database(entities = [Person::class], version = 1, exportSchema = false)
abstract class PersonsDatabase : RoomDatabase() {

    abstract val personsDAO: PersonsDAO
}