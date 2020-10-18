package cz.verunka.droid.ghibliki

import android.app.Application
import cz.verunka.droid.ghibliki.services.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GhibliApplication: Application() {

    override fun onCreate() {

        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@GhibliApplication)
            modules(
                apiModule, databaseModule, networkModule, repositoryModule, viewModelsModule
            )
        }
    }
}