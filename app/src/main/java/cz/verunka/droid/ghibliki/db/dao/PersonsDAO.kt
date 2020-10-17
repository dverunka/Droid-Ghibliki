package cz.verunka.droid.ghibliki.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cz.verunka.droid.ghibliki.db.model.Person

@Dao
interface PersonsDAO {

    @Query("SELECT * FROM Persons")
    fun getAll(): List<Person>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(persons: List<Person>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(person: Person)
}