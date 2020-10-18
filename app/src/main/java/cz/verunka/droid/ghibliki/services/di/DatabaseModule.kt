package cz.verunka.droid.ghibliki.services.di

import android.app.Application
import androidx.room.Room
import cz.verunka.droid.ghibliki.db.GhibliDatabase
import cz.verunka.droid.ghibliki.db.dao.MoviesDAO
import cz.verunka.droid.ghibliki.db.dao.PersonsDAO
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideGhibliDatabase(application: Application): GhibliDatabase {
        return Room.databaseBuilder(application, GhibliDatabase::class.java, "ghibli")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideMoviesDao(database: GhibliDatabase): MoviesDAO {
        return  database.moviesDao
    }

    fun providePersonsDao(database: GhibliDatabase): PersonsDAO {
        return  database.personsDAO
    }

    single { provideGhibliDatabase(application = androidApplication()) }

    single { provideMoviesDao(database = get()) }
    single { providePersonsDao(database = get()) }


}