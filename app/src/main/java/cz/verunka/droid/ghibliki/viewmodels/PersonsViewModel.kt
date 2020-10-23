package cz.verunka.droid.ghibliki.viewmodels

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.verunka.droid.ghibliki.db.model.Person
import cz.verunka.droid.ghibliki.services.repo.IGhibliRepository
import cz.verunka.droid.ghibliki.services.utils.AppResult
import cz.verunka.droid.ghibliki.services.utils.SingleLiveEvent
import kotlinx.coroutines.launch

class PersonsViewModel(private val repo: IGhibliRepository): ViewModel() {

    val showLoading = ObservableBoolean()
    val persons = MutableLiveData<List<Person>>()
    val showError = SingleLiveEvent<String>()

    fun getAllPersons() {

        showLoading.set(true)
        viewModelScope.launch {

            val result =  repo.getAllPersons()
            showLoading.set(false)

            when (result) {

                is AppResult.Success -> {
                    persons.value = result.successData
                    showError.value = null
                }
                is AppResult.Error -> showError.value = result.exception.message
            }
        }
    }
}