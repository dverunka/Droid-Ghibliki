package cz.verunka.droid.ghibliki.viewmodels

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.verunka.droid.ghibliki.db.model.Movie
import cz.verunka.droid.ghibliki.services.repo.IGhibliRepository
import cz.verunka.droid.ghibliki.services.utils.AppResult
import cz.verunka.droid.ghibliki.services.utils.SingleLiveEvent
import kotlinx.coroutines.launch

class MoviesViewModel(private val repo: IGhibliRepository): ViewModel() {

    val showLoading = ObservableBoolean()
    val movies = MutableLiveData<List<Movie>>()
    val showError = SingleLiveEvent<String>()

    fun getAllMovies() {

        showLoading.set(true)

        viewModelScope.launch {

            val result =  repo.getAllMovies()

            showLoading.set(false)

            when (result) {

                is AppResult.Success -> {
                    movies.value = result.successData
                    showError.value = null
                }
                is AppResult.Error -> showError.value = result.exception.message
            }
        }
    }
}