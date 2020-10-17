package cz.verunka.droid.ghibliki.services.di

import android.app.Application
import androidx.room.Room
import cz.verunka.droid.ghibliki.db.MoviesDatabase
import cz.verunka.droid.ghibliki.db.PersonsDatabase
import cz.verunka.droid.ghibliki.db.dao.MoviesDAO
import cz.verunka.droid.ghibliki.db.dao.PersonsDAO
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideMoviesDatabase(application: Application): MoviesDatabase {
        return Room.databaseBuilder(application, MoviesDatabase::class.java, "movies")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun providePersonsDatabase(application: Application): PersonsDatabase {
        return Room.databaseBuilder(application, PersonsDatabase::class.java, "persons")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideMoviesDao(database: MoviesDatabase): MoviesDAO {
        return  database.moviesDao
    }

    fun providePersonsDao(database: PersonsDatabase): PersonsDAO {
        return  database.personsDAO
    }

    single { provideMoviesDatabase(application = androidApplication()) }
    single { providePersonsDatabase(application = androidApplication()) }

    single { provideMoviesDao(database = get()) }
    single { providePersonsDao(database = get()) }


}