package cz.verunka.droid.ghibliki.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "Persons")
@Parcelize
class Person (

    @PrimaryKey(autoGenerate = false)
    val id: String,

    val name: String,
    val gender: String,
    val age: String, // unknown, teen, adult, ...
    val eye_color: String,
    val hair_color: String,

): Parcelable