package cz.verunka.droid.ghibliki.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "Movies")
@Parcelize
class Movie (

    @PrimaryKey(autoGenerate = false)
    val id: String,

    val title: String,
    val description: String,
    val director: String,
    val producer: String,
    val release_date: Int, // year

): Parcelable