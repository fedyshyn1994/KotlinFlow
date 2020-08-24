package com.fedyshyn.kotlinflow.viewmodel

import androidx.lifecycle.*
import com.fedyshyn.kotlinflow.repository.data.ApiLocationDetails
import com.fedyshyn.kotlinflow.repository.MainRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class MainViewModel(private val repository: MainRepository) : ViewModel() {

    private val _locationDetails = MutableLiveData<ApiLocationDetails>()
    val locationDetails: LiveData<ApiLocationDetails> get() = _locationDetails

    fun loadLocationDetails(locationId: Int) {
        viewModelScope.launch {
            repository.getLocationDetails(locationId)
                .onStart {
                }
                .collect {
                    _locationDetails.value = it
                }
        }
    }
}