package cz.verunka.droid.ghibliki.services.di

import android.content.Context
import cz.verunka.droid.ghibliki.db.dao.MoviesDAO
import cz.verunka.droid.ghibliki.db.dao.PersonsDAO
import cz.verunka.droid.ghibliki.services.api.GhibliApi
import cz.verunka.droid.ghibliki.services.repo.GhibliRepository
import cz.verunka.droid.ghibliki.services.repo.IGhibliRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {

    fun provideGhibliRepository(api: GhibliApi, context: Context, moviesDAO: MoviesDAO, personsDAO: PersonsDAO): IGhibliRepository {
        return GhibliRepository(api, context, moviesDAO, personsDAO)
    }

    single { provideGhibliRepository(api = get(), context = androidContext(), moviesDAO = get(), personsDAO = get()) }

}