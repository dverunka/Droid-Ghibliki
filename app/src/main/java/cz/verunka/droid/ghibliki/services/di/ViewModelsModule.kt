package cz.verunka.droid.ghibliki.services.di

import cz.verunka.droid.ghibliki.viewmodels.MoviesViewModel
import cz.verunka.droid.ghibliki.viewmodels.PersonsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MoviesViewModel(repo = get()) }

    viewModel { PersonsViewModel(repo = get()) }
}