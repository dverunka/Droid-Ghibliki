package cz.verunka.droid.ghibliki.services.di

import cz.verunka.droid.ghibliki.services.api.GhibliApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {

    fun provideGhibliApi(retrofit: Retrofit): GhibliApi {
        return retrofit.create(GhibliApi::class.java)
    }

    single { provideGhibliApi(retrofit = get()) }
}