package com.fedyshyn.kotlinflow.utils

import androidx.appcompat.app.AppCompatActivity
import com.fedyshyn.kotlinflow.repository.MainRepository
import com.fedyshyn.kotlinflow.viewmodel.MainViewModelFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
object InjectorUtils {

    private fun getMainRepository(): MainRepository {
        return MainRepository.getInstance()
    }

    fun provideMainViewModelFactory(activity: AppCompatActivity): MainViewModelFactory {
        val repository = getMainRepository()
        return MainViewModelFactory(repository, activity)
    }
}